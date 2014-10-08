package reparationservice.doubles;

import reparationservice.entities.impl.CustomerImpl;

public class NotEmptyCustomerSpy extends CustomerGatewaySpy {
	public static final int CUSTOMER_ID = 100;
	
	public NotEmptyCustomerSpy() {
		customer = new CustomerImpl(CUSTOMER_ID);
	}
}
