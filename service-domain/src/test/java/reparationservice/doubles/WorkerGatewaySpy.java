package reparationservice.doubles;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class WorkerGatewaySpy implements WorkerGateway {
	private Worker worker = Worker.NULL;

	@Override
	public void addWorker(Worker worker) {
		this.worker = worker;
	}

	@Override
	public Worker getWorkerByUserName(String workerUserName) {
		return worker;
	}

	public boolean addWorkerWasCalled() {
		return worker != Worker.NULL;
	}

	public Worker getAddedWorker() {
		return worker;
	}
}
