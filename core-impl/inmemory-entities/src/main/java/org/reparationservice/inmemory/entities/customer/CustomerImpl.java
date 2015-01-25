package org.reparationservice.inmemory.entities.customer;

import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.customer.Device;
import org.reparationservice.inmemory.InMemoryConfigurator;

import java.util.HashMap;
import java.util.Map;

public class CustomerImpl extends Customer {
	private final long customerId;
	private Map<Long, Device> devices = new HashMap<>();

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
				InMemoryConfigurator.getNewDevice(deviceSerialNumber));
	}
}
