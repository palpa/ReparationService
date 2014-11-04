package reparationservice.persistenceimpls.inmemory;

import reparationservice.entities.devicetype.DeviceType;

public class DeviceTypeImpl extends DeviceType {
	private String description;

	public DeviceTypeImpl(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
