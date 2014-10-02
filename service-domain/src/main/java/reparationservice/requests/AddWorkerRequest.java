package reparationservice.requests;

public class AddWorkerRequest extends Request {
	private String username;

	public AddWorkerRequest(String username) {
		this.username = username;
	}

	public String getUserName() {
		return username;
	}
}
