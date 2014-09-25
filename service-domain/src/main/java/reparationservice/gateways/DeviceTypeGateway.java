package reparationservice.gateways;

import reparationservice.entities.DeviceType;

public interface DeviceTypeGateway {
	DeviceType getDeviceType(String deviceTypeDescription);
	void addDeviceType(DeviceType deviceType);
}
