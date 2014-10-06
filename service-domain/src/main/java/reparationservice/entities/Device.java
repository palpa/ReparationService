package reparationservice.entities;

public abstract class Device {
	public static Device NULL = new NullDevice();

	private static class NullDevice extends Device {
	}
}
