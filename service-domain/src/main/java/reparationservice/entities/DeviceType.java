package reparationservice.entities;

public abstract class DeviceType {
	public static final DeviceType NULL = new NullDeviceType();

	public abstract String getDescription();
	
	private static class NullDeviceType extends DeviceType {
		@Override
		public String getDescription() {
			return "";
		}
	}
}
