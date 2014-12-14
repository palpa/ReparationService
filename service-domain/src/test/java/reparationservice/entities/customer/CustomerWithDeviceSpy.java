package reparationservice.entities.customer;


public class CustomerWithDeviceSpy extends NotEmptyCustomerSpy {
	public static final long DEVICE_SERIAL_NUMBER = 10;

	public CustomerWithDeviceSpy() {
		super();
		customer.addDevice(DEVICE_SERIAL_NUMBER);
	}

}
