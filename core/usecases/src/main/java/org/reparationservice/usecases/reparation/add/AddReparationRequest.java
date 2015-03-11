package org.reparationservice.usecases.reparation.add;

import org.joda.time.DateTime;

import org.reparationservice.requestor.UseCaseRequest;

public class AddReparationRequest implements UseCaseRequest {
  private final long customerId;
  private final DateTime creationDate;
  private final long deviceSerialNumber;
  private final String failure;
  private final String urgency;
  private final String observations;

  public AddReparationRequest(long customerId, long deviceSerialNumber,
      DateTime creationDate, String failure, String urgency,
      String observations) {
    this.customerId = customerId;
    this.creationDate = creationDate;
    this.deviceSerialNumber = deviceSerialNumber;
    this.failure = failure;
    this.urgency = urgency;
    this.observations = observations;
  }

  public long getCustomerId() {
    return customerId;
  }

  public DateTime getCreationDate() {
    return creationDate;
  }

  public long getDeviceSerialNumber() {
    return deviceSerialNumber;
  }

  public String getDeviceFailure() {
    return failure;
  }

  public String getUrgency() {
    return urgency;
  }

  public String getObservations() {
    return observations;
  }
}
