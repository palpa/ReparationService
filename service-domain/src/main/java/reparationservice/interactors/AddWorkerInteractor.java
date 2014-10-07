package reparationservice.interactors;

import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;
import reparationservice.requests.AddWorkerRequest;
import reparationservice.requests.Request;

public class AddWorkerInteractor implements Interactor {
	private WorkerGateway workers;

	public AddWorkerInteractor(WorkerGateway workers) {
		this.workers = workers;
	}

	@Override
	public void execute(Request request) {
		String workerUserName = ((AddWorkerRequest) request).getUserName();
		
		if (workers.getWorkerByUserName(workerUserName) != Worker.NULL)
			throw new WorkerAlreadyExists();
			
		workers.addWorker(new WorkerDTO(workerUserName));	
	}
	
	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 3471396866818354971L;
	}
}
