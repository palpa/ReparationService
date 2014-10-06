package reparationservice.entities;

public class Customer {
	public static final NullCustomer NULL = new NullCustomer();
	private long customerId;

	public static Customer newInstance(long customerId) {
		return new Customer(customerId);
	}

	public long getId() {
		return customerId;
	}

	protected Customer(long customerId) {
		this.customerId = customerId;
	}
	
	private static class NullCustomer extends Customer {
		protected NullCustomer() {
			super(0);
		}
	}

	public Device getDevice(long deviceSerialNumber) {
		return Device.NULL;
	}
}
