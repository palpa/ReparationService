package reparationservice.doubles;

import reparationservice.Configurator;

public class NotEmptyCustomerSpy extends CustomerGatewaySpy {
	public static final int CUSTOMER_ID = 100;
	
	public NotEmptyCustomerSpy() {
		customer = Configurator.getNewCustomer(CUSTOMER_ID);
	}
}
