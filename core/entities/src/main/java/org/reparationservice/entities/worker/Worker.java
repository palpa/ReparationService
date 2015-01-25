package org.reparationservice.entities.worker;

public abstract class Worker {
	public static final Worker NULL = new Worker() {
		@Override
		public String getUserName() {
			return "";
		}
	};

	public abstract String getUserName();
}
