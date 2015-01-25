package org.reparationservice.entities.customer;


public interface CustomerGateway {
	Customer getCustomerById(long customerId);
	void addCustomer(long customerId);
}
