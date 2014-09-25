package reparationservice.interactors;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class AddWorkerInteractor {

	private WorkerGateway workerGateway;
	private String workerUserName;

	public AddWorkerInteractor(String workerUserName, WorkerGateway workerGateway) {
		this.workerUserName = workerUserName;
		this.workerGateway = workerGateway;
	}

	public void execute() {
		if (workerGateway.getWorkerByUserName(workerUserName) != null)
			throw new WorkerAlreadyExists();
			
		workerGateway.addWorker(Worker.newInstance(workerUserName));	
	}
	
	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 3471396866818354971L;
	}
}
