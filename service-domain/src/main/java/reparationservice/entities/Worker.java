package reparationservice.entities;

public class Worker {
	public static final NullWorker NULL = new NullWorker();;
	private String userName;
	
	public static Worker newInstance(String workerUserName) {
		return new Worker(workerUserName);	
	}

	protected Worker(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	private static class NullWorker extends Worker {
		protected NullWorker() {
			super("");
		}
	}
}
