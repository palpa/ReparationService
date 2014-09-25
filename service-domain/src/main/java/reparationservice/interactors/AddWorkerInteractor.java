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
		workerGateway.addWorker(Worker.newInstance(workerUserName));	
	}

}
