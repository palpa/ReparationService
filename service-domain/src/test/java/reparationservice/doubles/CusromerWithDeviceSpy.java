package reparationservice.doubles;

public class CusromerWithDeviceSpy extends NotEmptyCustomerSpy {
	public static final long DEVICE_SERIAL_NUMBER = 10;

	public CusromerWithDeviceSpy() {
		super();
		customer.addDevice(DEVICE_SERIAL_NUMBER);
	}

}
