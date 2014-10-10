package reparationservice.doubles;

import reparationservice.Configurator;
import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;

public class CustomerGatewaySpy implements CustomerGateway {
	protected Customer customer;
	
	public CustomerGatewaySpy() {
		customer = Customer.NULL;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		return customer;
	}

	@Override
	public void addCustomer(long customerId) {
		customer = Configurator.getNewCustomer(customerId);
	}

	public boolean addCustomerWasCalled() {
		return customer != Customer.NULL;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
