package reparationservice.entities.impl;

import org.joda.time.DateTime;

import reparationservice.dtos.ReparationDTO;
import reparationservice.entities.Device;
import reparationservice.entities.Reparation;

public class DeviceImpl extends Device {
	private final long serialNumber;
	private Reparation reparation;

	public DeviceImpl(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public long getSerialNumber() {
		return serialNumber;
	}

	@Override
	public Reparation getReparation(DateTime creationDate) {
		return reparation;
	}

	@Override
	public void addReparation(ReparationDTO reparationDTO) {
		reparation = new ReparationImpl(reparationDTO);
	}
}
