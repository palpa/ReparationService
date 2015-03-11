package org.reparationservice.usecases.devicetype.add;

public class AddDeviceTypeResponderSpy implements AddDeviceTypeResponder {
  private boolean deviceTypeAlreadyExistsWasCalled = false;

  @Override public void deviceTypeAlreadyExists() {
    deviceTypeAlreadyExistsWasCalled = true;
  }

  public boolean deviceTypeAlreadyExistsWasCalled() {
    return deviceTypeAlreadyExistsWasCalled;
  }
}
