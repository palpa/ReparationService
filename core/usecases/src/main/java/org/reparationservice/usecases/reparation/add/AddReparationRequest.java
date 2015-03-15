package org.reparationservice.usecases.reparation.add;

import org.joda.time.DateTime;

import org.reparationservice.entities.customer.ReparationDTO;
import org.reparationservice.requestor.UseCaseRequest;

public class AddReparationRequest implements UseCaseRequest, AddReparationResponder, ReparationDTO {
  private final long customerId;
  private final DateTime creationDate;
  private final long deviceSerialNumber;
  private final String failure;
  private final String urgency;
  private final String observations;
  private final AddReparationResponder responder;

  public AddReparationRequest(long customerId, long deviceSerialNumber,
      DateTime creationDate, String failure, String urgency,
      String observations, AddReparationResponder responder) {
    this.customerId = customerId;
    this.creationDate = creationDate;
    this.deviceSerialNumber = deviceSerialNumber;
    this.failure = failure;
    this.urgency = urgency;
    this.observations = observations;
    this.responder = responder;
  }

  public long getCustomerId() {
    return customerId;
  }

  public long getDeviceSerialNumber() {
    return deviceSerialNumber;
  }

  @Override public DateTime getCreationDate() {
    return creationDate;
  }

  @Override public String getDeviceFailure() {
    return failure;
  }

  @Override public String getUrgency() {
    return urgency;
  }

  @Override public String getObservations() {
    return observations;
  }

  @Override public void customerNotFound() {
    responder.customerNotFound();
  }

  @Override public void deviceNotFound() {
    responder.deviceNotFound();
  }
}
