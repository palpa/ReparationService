package reparationservice.gateways;

import reparationservice.entities.Worker;

public interface WorkerGateway {

	public abstract void addWorker(Worker worker);

	public abstract Worker getWorkerByUserName(String workerUserName);
	
	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = -478576357592578461L;
	}
}