package reparationservice.usecases.customer;

import reparationservice.entities.customer.CustomerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public final class AddCustomerInteractor implements UseCaseActivator {
	private final CustomerGateway customers;
  private final UseCaseRequest request;

	public AddCustomerInteractor(CustomerGateway customers, UseCaseRequest request) {
		this.customers = customers;
		this.request = request;
	}

	@Override
	public void execute(UseCaseRequest request) {
		long customerId = ((AddCustomerRequest) this.request).getId();
		customers.addCustomer(customerId);	
	}
}
