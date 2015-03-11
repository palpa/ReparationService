package org.reparationservice.usecases.reparation.add;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.reparationservice.doubles.CustomerGatewaySpy;
import org.reparationservice.doubles.CustomerWithDeviceSpy;
import org.reparationservice.doubles.NotEmptyCustomerSpy;
import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.customer.Reparation;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

@RunWith(HierarchicalContextRunner.class)
public class AddReparationInteractorTest {
  private static final int CUSTOMER_ID = NotEmptyCustomerSpy.CUSTOMER_ID;
  private static final String DEVICE_FAILURE = "failure";
  private static final DateTime CREATION_DATE = DateTime.now();
  private static final long DEVICE_SERIAL_NUMBER = CustomerWithDeviceSpy.DEVICE_SERIAL_NUMBER;
  private static final String REPARATION_OBSERVATIONS = "observations";
  private static final String REPARATION_URGENCY = "urgency";

  private UseCaseActivator addReparation;
  private UseCaseRequest request;

  @Before
  public void givenRequest() throws Exception {
    request = createRequest();
  }

  @Test(expected = AddReparationInteractor.CustomerNotFound.class)
  public void throwCustomerNotFoundWhenProvidedCustomerIdDoesNotMatchWithAnyCustomer() {
    CustomerGateway emptyCustomersSpy = new CustomerGatewaySpy();
    addReparation = new AddReparationInteractor(emptyCustomersSpy);
    addReparation.execute(request);
  }

  public class CustomerIsFound {
    @Before
    public void givenCustomer() {
      CustomerGateway notEmptyCustomerSpy = new NotEmptyCustomerSpy();
      addReparation = new AddReparationInteractor(notEmptyCustomerSpy);
    }

    @Test(expected = AddReparationInteractor.DeviceNotFound.class)
    public void throwDeviceNotFoundWhenDeviceSerialNumberNotFound() {
      addReparation.execute(request);
    }

    public class DeviceIsFound {
      private CustomerGatewaySpy customerWithDeviceSpy;

      @Before
      public void givenDevice() {
        customerWithDeviceSpy = new CustomerWithDeviceSpy();
        addReparation = new AddReparationInteractor(customerWithDeviceSpy);
      }

      @Test
      public void addReparation() {
        addReparation.execute(request);

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
