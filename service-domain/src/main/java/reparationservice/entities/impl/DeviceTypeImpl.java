package reparationservice.entities.impl;

import reparationservice.entities.DeviceType;

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
