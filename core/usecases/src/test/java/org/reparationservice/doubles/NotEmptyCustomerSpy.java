package org.reparationservice.doubles;

public class NotEmptyCustomerSpy extends CustomerGatewaySpy {
	public static final int CUSTOMER_ID = 100;
	
	public NotEmptyCustomerSpy() {
		super();
		this.addCustomer(CUSTOMER_ID);
	}
}
