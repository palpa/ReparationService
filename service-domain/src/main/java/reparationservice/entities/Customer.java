package reparationservice.entities;

public abstract class Customer {
	public static final Customer NULL = new NullCustomer();
	public abstract long getId();
	public abstract Device getDevice(long deviceSerialNumber);
	public abstract void addDevice(long deviceSerialNumber);
	
	private static class NullCustomer extends Customer {
		@Override
		public long getId() {
			return 0;
		}
		@Override
		public Device getDevice(long deviceSerialNumber) {
			return Device.NULL;
		}
		@Override
		public void addDevice(long deviceSerialNumber) {
		}
	}
}
