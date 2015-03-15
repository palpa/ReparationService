package org.reparationservice.inmemory.entities.customer;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reparationservice.entities.customer.Device;
import org.reparationservice.entities.customer.Reparation;
import org.reparationservice.entities.customer.ReparationDTO;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(HierarchicalContextRunner.class)
public class DeviceTest {
  private static final int SERIAL_NUMBER = 150;
  private static final DateTime REP_CREATION_DATE_1 = DateTime.now();
  private static final DateTime REP_CREATION_DATE_2 = REP_CREATION_DATE_1
      .plusDays(1);
  private static final String REP_FAILURE = "failure";

  @Test
  public void addGetReparation() {
    Device device = new DeviceImpl((long) SERIAL_NUMBER);
    device.addReparation(newRepDTO(REP_CREATION_DATE_1));
    device.addReparation(newRepDTO(REP_CREATION_DATE_2));

    Reparation reparation1 = device
        .getReparation(REP_CREATION_DATE_1);
    assertThat(reparation1).isNotNull();
    assertThat(reparation1.getCreationDate()).isEqualTo(
        REP_CREATION_DATE_1);
    assertThat(reparation1.getDeviceFailure()).isEqualTo(
        REP_FAILURE);

    Reparation reparation2 = device
        .getReparation(REP_CREATION_DATE_2);
    assertThat(reparation2).isNotNull();
    assertThat(reparation2.getCreationDate()).isEqualTo(
        REP_CREATION_DATE_2);
    assertThat(reparation2.getDeviceFailure()).isEqualTo(
        REP_FAILURE);
  }

  private ReparationDTO newRepDTO(final DateTime creationDate) {
    return new ReparationDTO() {
      @Override public DateTime getCreationDate() {
        return creationDate;
      }

      @Override public String getDeviceFailure() {
        return REP_FAILURE;
      }

      @Override public String getUrgency() {
        return null;
      }

      @Override public String getObservations() {
        return null;
      }
    };
  }
}
