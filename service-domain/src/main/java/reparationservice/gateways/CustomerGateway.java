package reparationservice.gateways;

import reparationservice.entities.Customer;

public interface CustomerGateway {
	Customer getCustomerById(long customerId);
	void addCustomer(Customer customer);
}
