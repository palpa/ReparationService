package reparationservice.usecases.customer;

import reparationservice.requestor.UseCaseRequest;

public class AddCustomerRequest extends UseCaseRequest {
	private long id;

	public AddCustomerRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
