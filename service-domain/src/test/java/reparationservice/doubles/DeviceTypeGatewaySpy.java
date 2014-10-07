package reparationservice.doubles;

import reparationservice.entities.DeviceType;
import reparationservice.entities.impl.DeviceTypeImpl;
import reparationservice.gateways.DeviceTypeGateway;

public class DeviceTypeGatewaySpy implements DeviceTypeGateway {
	private DeviceType deviceType = DeviceType.NULL;

	@Override
	public void addDeviceType(String deviceTypeDescription) {
		this.deviceType = new DeviceTypeImpl(deviceTypeDescription);		
	}

	@Override
	public DeviceType getDeviceTypeBy(String deviceTypeDescription) {
		return deviceType;
	}

	public boolean addDeviceTypeWasCalled() {
		return (deviceType != DeviceType.NULL);
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}
}
