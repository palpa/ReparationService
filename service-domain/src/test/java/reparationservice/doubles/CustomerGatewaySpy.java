package reparationservice.doubles;

import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;

public class CustomerGatewaySpy implements CustomerGateway {
	protected Customer customer;
	
	public CustomerGatewaySpy() {
		customer = Customer.NULL;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		return this.customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean addCustomerWasCalled() {
		return this.customer != Customer.NULL;
	}
	
	public Customer getAddedCustomer() {
		return this.customer;
	}
}
