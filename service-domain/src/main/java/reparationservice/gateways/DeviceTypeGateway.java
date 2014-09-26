package reparationservice.gateways;

import reparationservice.entities.DeviceType;

public interface DeviceTypeGateway {
	void addDeviceType(DeviceType deviceType);
	DeviceType getDeviceTypeBy(String deviceTypeDescription);
}
