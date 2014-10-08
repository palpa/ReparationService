package reparationservice.entities;

public abstract class Device {
	public static Device NULL = new NullDevice();
	public abstract long getSerialNumber();

	private static class NullDevice extends Device {
		@Override
		public long getSerialNumber() {
			return -1;
		}
	}
}
