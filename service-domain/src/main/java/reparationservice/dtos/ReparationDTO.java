package reparationservice.dtos;

import org.joda.time.DateTime;

public class ReparationDTO {
	private final DateTime creationDate;

	public ReparationDTO(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}
}
