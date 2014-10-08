package reparationservice.entities.impl;

import reparationservice.entities.Device;

public class DeviceImpl extends Device {
	private final long serialNumber;

	public DeviceImpl(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public long getSerialNumber() {
		return serialNumber;
	}
}
