package reparationservice.entities.worker;


public interface WorkerGateway {
	public abstract void addWorker(WorkerDTO workerDTO);
	public abstract Worker getWorkerByUserName(String workerUserName);
}