package reparationservice.gateways;

import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Worker;

public interface WorkerGateway {
	public abstract void addWorker(WorkerDTO workerDTO);
	public abstract Worker getWorkerByUserName(String workerUserName);
}