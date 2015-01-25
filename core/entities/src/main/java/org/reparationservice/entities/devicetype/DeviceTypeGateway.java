package org.reparationservice.entities.devicetype;


public interface DeviceTypeGateway {
	void addDeviceType(String deviceTypeDescription);
	DeviceType getDeviceTypeBy(String deviceTypeDescription);
}
