package reparationservice.entities.worker;

import java.util.List;


public interface WorkerGateway {
	public abstract void addWorker(WorkerDTO workerDTO);
	public abstract Worker getWorkerByUserName(String workerUserName);
  public abstract List<Worker> getAllWorkers();
}