package org.reparationservice.usecases.worker.getall;

import java.util.Collection;

import org.reparationservice.entities.worker.WorkerDTO;

public interface GetAllWorkersResponder {
  void bindModel(Collection<WorkerDTO> workerList);
}
