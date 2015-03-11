package org.reparationservice.usecases.reparation.add;

import org.joda.time.DateTime;
import org.junit.Test;
import org.reparationservice.doubles.CustomerWithDeviceSpy;
import org.reparationservice.doubles.NotEmptyCustomerSpy;

import static org.assertj.core.api.Assertions.assertThat;

public class AddReparationRequestTest {
  private static final int CUSTOMER_ID = NotEmptyCustomerSpy.CUSTOMER_ID;
  private static final String DEVICE_FAILURE = "failure";
  private static final DateTime CREATION_DATE = DateTime.now();
  private static final long DEVICE_SERIAL_NUMBER = CustomerWithDeviceSpy.DEVICE_SERIAL_NUMBER;
  private static final String REPARATION_OBSERVATIONS = "observations";
  private static final String REPARATION_URGENCY = "urgency";

  @Test
  public void checkReparationRequestCreation() {
    AddReparationRequest repReq = new AddReparationRequest(CUSTOMER_ID, DEVICE_SERIAL_NUMBER,
        CREATION_DATE, DEVICE_FAILURE, REPARATION_URGENCY, REPARATION_OBSERVATIONS);

    assertThat(repReq.getCustomerId()).isEqualTo(CUSTOMER_ID);
    assertThat(repReq.getDeviceSerialNumber()).isEqualTo(DEVICE_SERIAL_NUMBER);
    assertThat(repReq.getCreationDate()).isEqualTo(CREATION_DATE);
    assertThat(repReq.getDeviceFailure()).isEqualTo(DEVICE_FAILURE);
    assertThat(repReq.getUrgency()).isEqualTo(REPARATION_URGENCY);
    assertThat(repReq.getObservations()).isEqualTo(REPARATION_OBSERVATIONS);
  }
}
