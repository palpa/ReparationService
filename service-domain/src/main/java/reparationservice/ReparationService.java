package reparationservice;

import java.util.ArrayList;
import java.util.List;

import reparationservice.entities.Worker;

public class ReparationService {
	private List<Worker> workers = new ArrayList<Worker>();
	
	public class WorkerAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = -478576357592578461L;
	}


	public void add(Worker worker) {
		if(workers.contains(worker))
			throw new WorkerAlreadyExists();
		workers.add(worker);
	}
	
	public Worker getWorkerByUserName(String workerUserName) {
		for (Worker worker : workers) {
			if (worker.getUserName().equals(workerUserName))
				return worker;
		}
			
		return null;
	}
}
