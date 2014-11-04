package reparationservice.entities.customer;

import reparationservice.entities.customer.Customer;
import reparationservice.entities.customer.CustomerGateway;
import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;

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
		customer = InMemoryConfigurator.getNewCustomer(customerId);
	}

	public boolean addCustomerWasCalled() {
		return customer != Customer.NULL;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
