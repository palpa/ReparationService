package reparationservice.interactors;

import org.joda.time.DateTime;

import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;

public class AddReparationInteractor implements Interactor {
	private CustomerGateway customers;
	private long customerId;

	public AddReparationInteractor(DateTime creationDate, String failure,
			String urgency, String observations, long customerId,
			long deviceSerialNumber, CustomerGateway customers) {
		this.customerId = customerId;
		this.customers = customers;
	}

	@Override
	public void execute() {
		if (customers.getCustomerById(customerId) == Customer.NULL)
			throw new CustomerNotFound();
	}

	public class CustomerNotFound extends RuntimeException {
		private static final long serialVersionUID = -4809605819126335670L;
	}
}
