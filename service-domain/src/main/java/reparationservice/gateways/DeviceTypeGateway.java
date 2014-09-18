package reparationservice.gateways;

import reparationservice.entities.DeviceType;

public interface DeviceTypeGateway {

	public class DeviceTypeAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = -6561716133848751271L;
	}

	DeviceType getDeviceType(String deviceTypeDescription);

	void addDeviceType(DeviceType deviceType);

}
