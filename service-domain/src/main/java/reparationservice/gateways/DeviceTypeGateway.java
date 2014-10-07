package reparationservice.gateways;

import reparationservice.entities.DeviceType;

public interface DeviceTypeGateway {
	void addDeviceType(String deviceTypeDescription);
	DeviceType getDeviceTypeBy(String deviceTypeDescription);
}
