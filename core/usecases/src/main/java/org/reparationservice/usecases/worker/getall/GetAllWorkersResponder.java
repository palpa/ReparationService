package reparationservice.usecases.worker.getall;

import java.util.Collection;

import reparationservice.entities.worker.WorkerDTO;

public interface GetAllWorkersResponder {
  void bindModel(Collection<WorkerDTO> workerList);
}
