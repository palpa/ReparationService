package reparationservice.entities;

public class DeviceType {
	public static final DeviceType NULL = new NullDeviceType();
	private final String description;
	
	public static DeviceType newInstance(String deviceTypeDescription) {
		return new DeviceType(deviceTypeDescription);
	}

	protected DeviceType(String description) {
		this.description =  description;
	}

	public String getDescription() {
		return description;
	}
	
	private static class NullDeviceType extends DeviceType {
		protected NullDeviceType() {
			super("");
		}
	}
}
