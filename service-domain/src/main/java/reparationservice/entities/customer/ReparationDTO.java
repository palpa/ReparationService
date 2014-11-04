package reparationservice.entities.customer;

import org.joda.time.DateTime;

public final class ReparationDTO {
	private final DateTime creationDate;
	private final String failure;

	public ReparationDTO(DateTime creationDate, String failure) {
		this.creationDate = creationDate;
		this.failure = failure;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public String getFailure() {
		return failure;
	}
}
