package reparationservice.entities.impl;

import reparationservice.Configurator;
import reparationservice.entities.Customer;
import reparationservice.entities.Device;

public class CustomerImpl extends Customer {
	private final long customerId;
	private Device device = Device.NULL;

	public CustomerImpl(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public long getId() {
		return customerId;
	}

	@Override
	public Device getDevice(long deviceSerialNumber) {
		if (device.getSerialNumber() == deviceSerialNumber)
			return device;
		return Device.NULL;
	}

	@Override
	public void addDevice(long deviceSerialNumber) {
		device = Configurator.getNewDevice(deviceSerialNumber);
	}
}
