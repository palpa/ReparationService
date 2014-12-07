package reparationservice.usecases.worker.add;

import reparationservice.requestor.UseCaseRequest;

public class AddWorkerRequest extends UseCaseRequest {
	private String username;

	public AddWorkerRequest(String username) {
		this.username = username;
	}

	public String getUserName() {
		return username;
	}
}
