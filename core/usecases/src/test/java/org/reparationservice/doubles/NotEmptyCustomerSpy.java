package org.reparationservice.doubles;

import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;

public class NotEmptyCustomerSpy extends CustomerGatewaySpy {
	public static final int CUSTOMER_ID = 100;
	
	public NotEmptyCustomerSpy() {
		org.reparationservice.usecases.customer = InMemoryConfigurator.getNewCustomer(CUSTOMER_ID);
	}
}
