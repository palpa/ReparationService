package reparationservice.requests;

public class AddCustomerRequest extends Request {
	private long id;

	public AddCustomerRequest(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
