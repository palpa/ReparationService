package reparationservice.usecases.devicetype;

import reparationservice.requestor.UseCaseRequest;

public class AddDeviceTypeRequest extends UseCaseRequest {
	private String deviceTypeDescription;

	public AddDeviceTypeRequest(String deviceTypeDescription) {
		this.deviceTypeDescription = deviceTypeDescription;
	}

	public String getDescription() {
		return deviceTypeDescription;
	}
}
