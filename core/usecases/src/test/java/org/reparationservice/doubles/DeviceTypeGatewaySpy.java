package org.reparationservice.doubles;

import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.inmemory.InMemoryConfigurator;

public class DeviceTypeGatewaySpy implements DeviceTypeGateway {
	private DeviceType deviceType = DeviceType.NULL;

	@Override
	public void addDeviceType(final String deviceTypeDescription) {
		this.deviceType = InMemoryConfigurator.getNewDeviceType(deviceTypeDescription);
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
