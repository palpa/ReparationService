package reparationservice.persistenceimpls.inmemory;

import org.joda.time.DateTime;

import reparationservice.entities.customer.Reparation;
import reparationservice.entities.customer.ReparationDTO;

public final class ReparationImpl extends Reparation {
	private final DateTime creationDate;
	private final String failure;

	public ReparationImpl(ReparationDTO reparationDTO) {
		this.creationDate = reparationDTO.getCreationDate();
		this.failure = reparationDTO.getFailure();
	}

	@Override
	public DateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public String getFailure() {
		return failure;
	}
}
