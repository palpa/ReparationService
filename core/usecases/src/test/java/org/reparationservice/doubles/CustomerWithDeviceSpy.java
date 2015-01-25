package org.reparationservice.doubles;


public class CustomerWithDeviceSpy extends NotEmptyCustomerSpy {
	public static final long DEVICE_SERIAL_NUMBER = 10;

	public CustomerWithDeviceSpy() {
		super();
		org.reparationservice.usecases.customer.addDevice(DEVICE_SERIAL_NUMBER);
	}

}
