package reparationservice.gateways;

import reparationservice.entities.DeviceType;

public interface DeviceTypeGateway {
	DeviceType getDeviceTypeBy(String deviceTypeDescription);
	void addDeviceType(DeviceType deviceType);
}
