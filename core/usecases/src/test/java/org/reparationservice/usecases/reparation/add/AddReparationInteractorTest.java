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
  private AddReparationResponder responder;

  @Before
  public void givenRequest() throws Exception {
    responder = new AddReparationResponderSpy();
    request = new AddReparationRequest(CUSTOMER_ID, DEVICE_SERIAL_NUMBER,
        CREATION_DATE, DEVICE_FAILURE, REPARATION_URGENCY,
        REPARATION_OBSERVATIONS, responder);
  }

  @Test
  public void callCustomerNotFoundWhenProvidedCustomerIdDoesNotMatchWithAnyCustomer() {
    CustomerGateway emptyCustomersSpy = new CustomerGatewaySpy();
    addReparation = new AddReparationInteractor(emptyCustomersSpy);
    addReparation.execute(request);

    assertThat(((AddReparationResponderSpy) responder).customerNotFoundWasCalledTimes())
        .isEqualTo(1);
  }

  public class CustomerIsFound {
    @Before
    public void givenCustomer() {
      CustomerGateway notEmptyCustomerSpy = new NotEmptyCustomerSpy();
      addReparation = new AddReparationInteractor(notEmptyCustomerSpy);
    }

    @Test
    public void callDeviceNotFoundWhenDeviceSerialNumberNotFound() {
      addReparation.execute(request);
      assertThat(((AddReparationResponderSpy) responder).deviceNotFoundWasCalledTimes())
          .isEqualTo(1);
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
}
