package reparationservice.interactors;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class AddWorkerInteractor implements Interactor {
	private WorkerGateway workers;
	private String workerUserName;

	public AddWorkerInteractor(String workerUserName, WorkerGateway workers) {
		this.workerUserName = workerUserName;
		this.workers = workers;
	}

	@Override
	public void execute() {
		if (workers.getWorkerByUserName(workerUserName) != null)
			throw new WorkerAlreadyExists();
			
		workers.addWorker(Worker.newInstance(workerUserName));	
	}
	
	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 3471396866818354971L;
	}
}
