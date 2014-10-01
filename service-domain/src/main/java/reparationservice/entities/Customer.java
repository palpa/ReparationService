package reparationservice.entities;

import org.joda.time.DateTime;

public class Customer {
	private long customerId;

	public static Customer newInstance(long customerId) {
		return new Customer(customerId);
	}

	public long getId() {
		return customerId;
	}
	
	public Reparation getReparation(long deviceSerialNumber,
			DateTime creationDate) {
		// TODO Auto-generated method stub
		return null;
	}

	private Customer(long customerId) {
		this.customerId = customerId;
	}
}
