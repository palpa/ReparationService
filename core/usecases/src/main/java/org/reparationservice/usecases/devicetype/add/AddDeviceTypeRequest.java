package org.reparationservice.usecases.devicetype.add;

import org.reparationservice.requestor.UseCaseRequest;

public class AddDeviceTypeRequest extends UseCaseRequest implements AddDeviceTypeResponder {
  private final AddDeviceTypeResponder responder;
  private String deviceTypeDescription;

  public AddDeviceTypeRequest(String deviceTypeDescription, AddDeviceTypeResponder responder) {
    if (responder == null)
      throw new ResponderCannotBeNull();

    this.deviceTypeDescription = deviceTypeDescription;
    this.responder = responder;
  }

  public String getDescription() {
    return deviceTypeDescription;
  }

  @Override public void deviceTypeAlreadyExists() {
    responder.deviceTypeAlreadyExists();
  }

  class ResponderCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = 5547829616355926992L;
  }
}
