package reparationservice.entities.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import reparationservice.dtos.ReparationDTO;
import reparationservice.entities.Device;
import reparationservice.entities.Reparation;

public final class DeviceImpl extends Device {
	private final long serialNumber;
	private final Map<DateTime, Reparation> reparations = new HashMap<DateTime, Reparation>();

	public DeviceImpl(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public long getSerialNumber() {
		return serialNumber;
	}

	@Override
	public Reparation getReparation(DateTime creationDate) {
		return reparations.get(creationDate);
	}

	@Override
	public void addReparation(ReparationDTO reparationDTO) {
		reparations.put(reparationDTO.getCreationDate(), new ReparationImpl(reparationDTO));
	}
}
