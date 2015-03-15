package org.reparationservice.entities.customer;

import org.joda.time.DateTime;

public interface ReparationDTO {
  DateTime getCreationDate();

  String getDeviceFailure();

  String getUrgency();

  String getObservations();
}
