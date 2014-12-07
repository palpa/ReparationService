package reparationservice.usecases.worker.add;

import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;
import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public final class AddWorkerInteractor implements UseCaseActivator {
	private final WorkerGateway workers;
  private final UseCaseRequest request;

	public AddWorkerInteractor(WorkerGateway workers, UseCaseRequest request) {
		this.workers = workers;
		this.request = request;
	}

	@Override
	public void execute() {
		String workerUserName = ((AddWorkerRequest) this.request).getUserName();
		
		if (workers.getWorkerByUserName(workerUserName) != Worker.NULL)
			throw new WorkerAlreadyExists();
			
		workers.addWorker(new WorkerDTO(workerUserName));	
	}

	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 3471396866818354971L;
	}
}
