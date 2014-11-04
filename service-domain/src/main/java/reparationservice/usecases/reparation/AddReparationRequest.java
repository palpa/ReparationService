package reparationservice.usecases.reparation;

import org.joda.time.DateTime;

import reparationservice.requestor.UseCaseRequest;

public class AddReparationRequest extends UseCaseRequest {
	private long customerId;
	private DateTime creationDate;
	private long deviceSerialNumber;
	private String failure;

	public AddReparationRequest(long customerId, long deviceSerialNumber,
			DateTime creationDate, String failure, String urgency,
			String observations) {
		this.customerId = customerId;
		this.creationDate = creationDate;
		this.deviceSerialNumber = deviceSerialNumber;
		this.failure = failure;
	}

	public long getCustomerId() {
		return customerId;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public long getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public String getDeviceFailure() {
		return failure;
	}
}
