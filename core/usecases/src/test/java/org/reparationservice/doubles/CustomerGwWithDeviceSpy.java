package org.reparationservice.doubles;

public class CustomerGwWithDeviceSpy extends NotEmptyCustomerSpy {
	public static final long DEVICE_SERIAL_NUMBER = 10;

	public CustomerGwWithDeviceSpy() {
		super();
    this.getCustomer().addDevice(DEVICE_SERIAL_NUMBER);
	}
}
