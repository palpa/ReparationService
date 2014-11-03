package reparationservice.interactors;

import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;
import reparationservice.interactors.requests.AddWorkerRequest;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public class AddWorkerInteractor implements UseCaseActivator {
	private WorkerGateway workers;

	public AddWorkerInteractor(WorkerGateway workers) {
		this.workers = workers;
	}

	@Override
	public void execute(UseCaseRequest request) {
		String workerUserName = ((AddWorkerRequest) request).getUserName();
		
		if (workers.getWorkerByUserName(workerUserName) != Worker.NULL)
			throw new WorkerAlreadyExists();
			
		workers.addWorker(new WorkerDTO(workerUserName));	
	}
	
	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 3471396866818354971L;
	}
}
