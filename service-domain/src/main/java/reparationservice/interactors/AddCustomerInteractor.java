package reparationservice.interactors;

import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddCustomerRequest;
import reparationservice.requests.Request;

public class AddCustomerInteractor implements Interactor {
	private CustomerGateway customers;

	public AddCustomerInteractor(CustomerGateway customers) {
		this.customers = customers;
	}

	@Override
	public void execute(Request request) {
		long customerId = ((AddCustomerRequest) request).getId();
		customers.addCustomer(customerId);	
	}
}
