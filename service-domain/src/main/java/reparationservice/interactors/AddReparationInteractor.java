package reparationservice.interactors;

import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddReparationRequest;
import reparationservice.requests.Request;

public class AddReparationInteractor implements Interactor {
	private CustomerGateway customers;

	public AddReparationInteractor(CustomerGateway customers) {
		this.customers = customers;
	}

	@Override
	public void execute(Request request) {
		AddReparationRequest repReq = (AddReparationRequest) request;
		Customer customer = customers.getCustomerById(repReq.getCustomerId());
		if (customer == Customer.NULL)
			throw new CustomerNotFound();
		
		customer.addReparation(repReq.getCreationDate(), repReq.getDeviceSerialNumber(), repReq.getDeviceFailure());
	}

	public class CustomerNotFound extends RuntimeException {
		private static final long serialVersionUID = -4809605819126335670L;
	}
}
