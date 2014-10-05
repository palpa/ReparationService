package reparationservice.entities;

import org.joda.time.DateTime;

public class Customer {
	public static final NullCustomer NULL = new NullCustomer();
	private long customerId;
	private Reparation reparation;

	public static Customer newInstance(long customerId) {
		return new Customer(customerId);
	}

	public long getId() {
		return customerId;
	}

	public Reparation getReparation(long deviceSerialNumber,
			DateTime creationDate) {
		return reparation;
	}

	protected Customer(long customerId) {
		this.customerId = customerId;
	}
	
	private static class NullCustomer extends Customer {
		protected NullCustomer() {
			super(0);
		}
	}

	public void addReparation(DateTime creationDate, long deviceSerialNumber,
			String deviceFailure) {
		reparation = Reparation.newInstance(creationDate, deviceSerialNumber, deviceFailure);
		
	}
}
