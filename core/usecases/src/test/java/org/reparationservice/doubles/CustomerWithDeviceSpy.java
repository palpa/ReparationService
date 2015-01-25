package org.reparationservice.doubles;

public class CustomerWithDeviceSpy extends NotEmptyCustomerSpy {
	public static final long DEVICE_SERIAL_NUMBER = 10;

	public CustomerWithDeviceSpy() {
		super();
		this.addDevice(DEVICE_SERIAL_NUMBER);
	}
}
