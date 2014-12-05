package reparationservice.usecases.reparation;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.entities.customer.CusromerWithDeviceSpy;
import reparationservice.entities.customer.CustomerGateway;
import reparationservice.entities.customer.CustomerGatewaySpy;
import reparationservice.entities.customer.NotEmptyCustomerSpy;
import reparationservice.entities.customer.Reparation;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.reparation.AddReparationInteractor;
import reparationservice.usecases.reparation.AddReparationRequest;

@RunWith(HierarchicalContextRunner.class)
public class AddReparationInteractorTest {
  private static final int CUSTOMER_ID = NotEmptyCustomerSpy.CUSTOMER_ID;
  private static final String DEVICE_FAILURE = "failure";
  private static final DateTime CREATION_DATE = DateTime.now();
  private static final long DEVICE_SERIAL_NUMBER = CusromerWithDeviceSpy.DEVICE_SERIAL_NUMBER;
  private static final String REPARATION_OBSERVATIONS = "observations";
  private static final String REPARATION_URGENCY = "urgency";

  private UseCaseActivator addReparation;
  private UseCaseRequest request;

  @Before
  public void givenRequest() throws Exception {
    request = createRequest();
  }

  @Test
  public void checkReparationRequest() {
    AddReparationRequest repReq = (AddReparationRequest) request;
    assertThat(repReq.getCustomerId()).isEqualTo(CUSTOMER_ID);
    assertThat(repReq.getCreationDate()).isEqualTo(CREATION_DATE);
    assertThat(repReq.getDeviceSerialNumber()).isEqualTo(
        DEVICE_SERIAL_NUMBER);
    assertThat(repReq.getDeviceFailure()).isEqualTo(DEVICE_FAILURE);
  }

  @Test(expected = AddReparationInteractor.CustomerNotFound.class)
  public void throwCustomerNotFoundWhenProvidedCustomerIdDontMatchWithAnyCustomer() {
    CustomerGateway emptyCustomersSpy = new CustomerGatewaySpy();
    addReparation = new AddReparationInteractor(emptyCustomersSpy, request);
    addReparation.execute();
  }

  public class CustomerIsFound {
    @Before
    public void givenCustomer() {
      CustomerGateway notEmptyCustomerSpy = new NotEmptyCustomerSpy();
      addReparation = new AddReparationInteractor(notEmptyCustomerSpy, request);
    }

    @Test(expected = AddReparationInteractor.DeviceNotFound.class)
    public void throwDeviceNotFoundWhenDeviceSerialNumberNotFound() {
      addReparation.execute();
    }

    public class DeviceIsFound {
      private CustomerGatewaySpy customerWithDeviceSpy;

      @Before
      public void givenDevice() {
        customerWithDeviceSpy = new CusromerWithDeviceSpy();
        addReparation = new AddReparationInteractor(customerWithDeviceSpy, request);
      }

      @Test
      public void addReparation() {
        addReparation.execute();

        Reparation reparation = getReparation(DEVICE_SERIAL_NUMBER,
            CREATION_DATE, customerWithDeviceSpy);
        assertThat(reparation).isNotNull();
        assertThat(reparation.getCreationDate()).isEqualTo(
            CREATION_DATE);
      }

      private Reparation getReparation(long deviceSerialNumber,
          DateTime creationDate, CustomerGatewaySpy customerGatewaySpy) {
        return customerGatewaySpy.getCustomer()
            .getDevice(deviceSerialNumber)
            .getReparation(creationDate);
      }
    }
  }

  private UseCaseRequest createRequest() {
    return new AddReparationRequest(CUSTOMER_ID, DEVICE_SERIAL_NUMBER,
        CREATION_DATE, DEVICE_FAILURE, REPARATION_URGENCY,
        REPARATION_OBSERVATIONS);
  }
}
