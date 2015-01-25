package org.reparationservice.usecases.devicetype.add;

import org.reparationservice.requestor.UseCaseRequest;

public class AddDeviceTypeRequest extends UseCaseRequest {
	private String deviceTypeDescription;

	public AddDeviceTypeRequest(String deviceTypeDescription) {
		this.deviceTypeDescription = deviceTypeDescription;
	}

	public String getDescription() {
		return deviceTypeDescription;
	}
}
