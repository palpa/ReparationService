package org.reparationservice.usecases.customer.add;

import org.reparationservice.requestor.UseCaseRequest;

public class AddCustomerRequest implements UseCaseRequest {
	private long id;

	public AddCustomerRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
