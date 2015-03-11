package org.reparationservice.doubles;

import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;

public class DeviceTypeGatewaySpy implements DeviceTypeGateway {
  private DeviceType deviceType = DeviceType.NULL;
  private int addDeviceTypeCalledTines = 0;

  @Override
  public void addDeviceType(final String deviceTypeDescription) {
    addDeviceTypeCalledTines++;

    this.deviceType = new DeviceType() {
      @Override
      public String getDescription() {
        return deviceTypeDescription;
      }
    };
  }

  @Override
  public DeviceType getDeviceTypeBy(String deviceTypeDescription) {
    return deviceType;
  }

  public boolean addDeviceTypeWasCalled() {
    return addDeviceTypeCalledTines > 0;
  }

  public int addDeviceTypeCalledTimes() {
    return addDeviceTypeCalledTines;
  }

  public DeviceType getDeviceType() {
    return deviceType;
  }
}
