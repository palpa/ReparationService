package reparationservice.entities.worker;

import java.util.Collection;

public interface WorkerGateway {
  void addWorker(WorkerDTO workerDTO);
  Worker getWorkerByUserName(String workerUserName);
  Collection<Worker> getAllWorkers();
}
