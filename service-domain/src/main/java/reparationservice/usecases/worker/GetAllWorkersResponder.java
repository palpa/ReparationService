package reparationservice.usecases.worker;

import java.util.List;

import reparationservice.entities.worker.Worker;

public interface GetAllWorkersResponder {
  List<Worker> getModel();
  void bindModel(List<Worker> workerList);
}
