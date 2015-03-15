package org.reparationservice.usecases.reparation.add;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.reparationservice.doubles.CustomerGatewaySpy;
import org.reparationservice.doubles.CustomerGwWithDeviceSpy;
import org.reparationservice.doubles.NotEmptyCustomerSpy;
import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.customer.ReparationDTO;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

@RunWith(HierarchicalContextRunner.class)
public class AddReparationInteractorTest {
  private static final int CUSTOMER_ID = NotEmptyCustomerSpy.CUSTOMER_ID;
  private static final String DEVICE_FAILURE = "failure";
  private static final DateTime CREATION_DATE = DateTime.now();
  private static final long DEVICE_SERIAL_NUMBER = CustomerGwWithDeviceSpy.DEVICE_SERIAL_NUMBER;
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
    assertThat(((CustomerGatewaySpy) emptyCustomersSpy).addReparationCalledTimes()).
        isEqualTo(0);
  }

  public class CustomerIsFound {
    private CustomerGateway notEmptyCustomerSpy;

    @Before
    public void givenCustomer() {
      notEmptyCustomerSpy = new NotEmptyCustomerSpy();
      addReparation = new AddReparationInteractor(notEmptyCustomerSpy);
    }

    @Test
    public void callDeviceNotFoundWhenDeviceSerialNumberNotFound() {
      addReparation.execute(request);
      assertThat(((AddReparationResponderSpy) responder).deviceNotFoundWasCalledTimes())
          .isEqualTo(1);
      assertThat(((NotEmptyCustomerSpy) notEmptyCustomerSpy).addReparationCalledTimes()).
          isEqualTo(0);
    }

    public class DeviceIsFound {
      private CustomerGateway customerGwWithDevice;

      @Before
      public void givenDevice() {
        customerGwWithDevice = new CustomerGwWithDeviceSpy();
        addReparation = new AddReparationInteractor(customerGwWithDevice);
      }

      @Test
      public void addReparation() {
        addReparation.execute(request);

        CustomerGwWithDeviceSpy customerGwWithDeviceSpy = (CustomerGwWithDeviceSpy) customerGwWithDevice;
        assertThat(customerGwWithDeviceSpy.addReparationCalledTimes()).isEqualTo(1);
        ReparationDTO reparationDTO = (AddReparationRequest)request;
        assertThat(customerGwWithDeviceSpy.addReparationWasCalledWith(reparationDTO)).isTrue();
      }
    }
  }
}
