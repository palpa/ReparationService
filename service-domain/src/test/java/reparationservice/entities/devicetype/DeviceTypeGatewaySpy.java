package reparationservice.entities.devicetype;

import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGateway;
import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;

public class DeviceTypeGatewaySpy implements DeviceTypeGateway {
	private DeviceType deviceType = DeviceType.NULL;

	@Override
	public void addDeviceType(String deviceTypeDescription) {
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
