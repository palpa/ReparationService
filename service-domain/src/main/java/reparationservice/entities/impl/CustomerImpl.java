package reparationservice.entities.impl;

import java.util.HashMap;
import java.util.Map;

import reparationservice.Configurator;
import reparationservice.entities.Customer;
import reparationservice.entities.Device;

public class CustomerImpl extends Customer {
	private final long customerId;
	private Map<Long, Device> devices = new HashMap<Long, Device>();

	public CustomerImpl(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public long getId() {
		return customerId;
	}

	@Override
	public Device getDevice(long deviceSerialNumber) {
		if (devices.containsKey(deviceSerialNumber))
			return devices.get(deviceSerialNumber);
		return Device.NULL;
	}

	@Override
	public void addDevice(long deviceSerialNumber) {
		devices.put(deviceSerialNumber,
				Configurator.getNewDevice(deviceSerialNumber));
	}
}
