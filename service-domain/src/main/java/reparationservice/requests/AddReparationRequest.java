package reparationservice.requests;

import org.joda.time.DateTime;

public class AddReparationRequest extends Request {
	private long customerId;

	public AddReparationRequest(DateTime creationDate, String failure,
			String urgency, String observations, long customerId,
			long deviceSerialNumber) {
		this.customerId = customerId;
	}

	public long getCustomerId() {
		return customerId;
	}
}
