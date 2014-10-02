package reparationservice.requests;

public class AddDeviceTypeRequest extends Request {
	private String deviceTypeDescription;

	public AddDeviceTypeRequest(String deviceTypeDescription) {
		this.deviceTypeDescription = deviceTypeDescription;
	}

	public String getDescription() {
		return deviceTypeDescription;
	}
}
