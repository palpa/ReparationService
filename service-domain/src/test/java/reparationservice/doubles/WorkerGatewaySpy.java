package reparationservice.doubles;

import reparationservice.Configurator;
import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class WorkerGatewaySpy implements WorkerGateway {
	private Worker worker = Worker.NULL;

	@Override
	public void addWorker(WorkerDTO workerDTO) {
		this.worker = Configurator.getNewWorker(workerDTO);
	}

	@Override
	public Worker getWorkerByUserName(String workerUserName) {
		return worker;
	}

	public boolean addWorkerWasCalled() {
		return worker != Worker.NULL;
	}

	public Worker getWorker() {
		return worker;
	}
}
