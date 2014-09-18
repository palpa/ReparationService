package reparationservice;

import java.util.ArrayList;
import java.util.List;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class ReparationService implements WorkerGateway {
	private List<Worker> workers = new ArrayList<Worker>();
	
	@Override
	public void addWorker(Worker worker) {
		if(workers.contains(worker))
			throw new WorkerAlreadyExists();
		workers.add(worker);
	}
	
	@Override
	public Worker getWorkerByUserName(String workerUserName) {
		for (Worker worker : workers) {
			if (worker.getUserName().equals(workerUserName))
				return worker;
		}
			
		return null;
	}
}
