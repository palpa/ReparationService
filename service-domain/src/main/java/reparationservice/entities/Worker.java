package reparationservice.entities;

public abstract class Worker {
	public static final Worker NULL = new Worker() {
		@Override
		public String getUserName() {
			return "";
		}
	};

	public abstract String getUserName();
}
