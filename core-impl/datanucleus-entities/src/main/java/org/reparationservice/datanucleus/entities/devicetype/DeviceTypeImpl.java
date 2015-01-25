package org.reparationservice.datanucleus.entities.devicetype;

import org.reparationservice.entities.devicetype.DeviceType;

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
