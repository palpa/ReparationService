package reparationservice.interactors;

import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;

public class AddCustomerInteractor implements Interactor {

	private CustomerGateway customers;
	private long customerId;

	public AddCustomerInteractor(long customerId, CustomerGateway customers) {
		this.customerId = customerId;
		this.customers = customers;
	}

	@Override
	public void execute() {
		customers.addCustomer(Customer.newInstance(customerId));
	}

}
