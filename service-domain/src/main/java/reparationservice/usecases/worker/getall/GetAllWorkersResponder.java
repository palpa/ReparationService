package reparationservice.usecases.worker.getall;

import reparationservice.entities.worker.Worker;

public interface GetAllWorkersResponder {
  void bindModel(Iterable<Worker> workerList);
}
