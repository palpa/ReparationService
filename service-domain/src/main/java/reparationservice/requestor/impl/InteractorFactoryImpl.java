package reparationservice.requestor.impl;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.add.AddWorkerInteractor;
import reparationservice.usecases.worker.getall.GetAllWorkerInteractor;
import reparationservice.usecases.worker.getall.GetAllWorkersResponder;

public class InteractorFactoryImpl implements InteractorFactory {
  @Override
  public UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers, UseCaseRequest request) {
    return new AddWorkerInteractor(workers, request);
  }

  @Override
  public UseCaseActivator makeGetAllWorkersInteractor(WorkerGateway workers,
      GetAllWorkersResponder getAllWorkersResponder) {
    return new GetAllWorkerInteractor(workers, getAllWorkersResponder);
  }
}
