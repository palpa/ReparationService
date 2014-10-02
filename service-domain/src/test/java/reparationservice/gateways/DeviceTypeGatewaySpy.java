package reparationservice.gateways;

import reparationservice.entities.DeviceType;

public class DeviceTypeGatewaySpy implements DeviceTypeGateway {
	private DeviceType deviceType = DeviceType.NULL;

	@Override
	public void addDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;		
	}

	@Override
	public DeviceType getDeviceTypeBy(String deviceTypeDescription) {
		return deviceType;
	}

	public boolean addDeviceTypeWasCalled() {
		return (deviceType != DeviceType.NULL);
	}
}
