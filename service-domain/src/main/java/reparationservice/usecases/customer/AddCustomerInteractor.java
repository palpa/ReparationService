package reparationservice.usecases.customer;

import reparationservice.entities.customer.CustomerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public class AddCustomerInteractor implements UseCaseActivator {
	private CustomerGateway customers;

	public AddCustomerInteractor(CustomerGateway customers) {
		this.customers = customers;
	}

	@Override
	public void execute(UseCaseRequest request) {
		long customerId = ((AddCustomerRequest) request).getId();
		customers.addCustomer(customerId);	
	}
}
