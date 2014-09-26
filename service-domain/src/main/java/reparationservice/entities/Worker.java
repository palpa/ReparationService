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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	private static class NullWorker extends Worker {
		protected NullWorker() {
			super("");
		}
	}
}
