package reparationservice.entities;

public abstract class Worker {
	public static final Worker NULL = new NullWorker();;
	
	public abstract String getUserName();
	
	private static class NullWorker extends Worker {
		@Override
		public String getUserName() {
			return "";
		}
	}
}
