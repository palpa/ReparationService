package reparationservice.entities.impl;

import org.joda.time.DateTime;

import reparationservice.dtos.ReparationDTO;
import reparationservice.entities.Reparation;

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
