package reparationservice.entities.worker;

import java.util.Collection;

import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;
import reparationservice.entities.worker.WorkerGateway;
import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;

public class WorkerGatewaySpy implements WorkerGateway {
	private Worker worker = Worker.NULL;

	@Override
	public void addWorker(WorkerDTO workerDTO) {
		this.worker = InMemoryConfigurator.getNewWorker(workerDTO);
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

  @Override
  public Collection<Worker> getAllWorkers() {
    return null;
  }
}
