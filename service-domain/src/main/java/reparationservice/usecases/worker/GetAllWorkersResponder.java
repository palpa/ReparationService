package reparationservice.usecases.worker;

import reparationservice.entities.worker.Worker;

public interface GetAllWorkersResponder {
  void bindModel(Iterable<Worker> workerList);
}
