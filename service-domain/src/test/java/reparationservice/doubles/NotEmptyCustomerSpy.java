package reparationservice.doubles;

import reparationservice.entities.Customer;

public class NotEmptyCustomerSpy extends CustomerGatewaySpy {
	public static final int CUSTOMER_ID = 100;
	
	public NotEmptyCustomerSpy() {
		customer = Customer.newInstance(CUSTOMER_ID);
	}
}
