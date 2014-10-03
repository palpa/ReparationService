package reparationservice.doubles;

import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;

public class CustomerGatewaySpy implements CustomerGateway {
	private Customer customer = Customer.NULL;

	@Override
	public Customer getCustomerById(long customerId) {
		return customer;
	}

	@Override
	public void addCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean addCustomerWasCalled() {
		return customer != Customer.NULL;
	}
	
	public Customer getAddedCustomer() {
		return customer;
	}
}
