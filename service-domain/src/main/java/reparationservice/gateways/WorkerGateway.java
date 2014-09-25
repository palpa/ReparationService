package reparationservice.gateways;

import reparationservice.entities.Worker;

public interface WorkerGateway {
	public abstract void addWorker(Worker worker);
	public abstract Worker getWorkerByUserName(String workerUserName);
}