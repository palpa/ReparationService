package org.reparationservice.requestor.impl;

import org.reparationservice.requestor.InteractorFactory;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.usecases.worker.add.AddWorkerInteractor;
import org.reparationservice.usecases.worker.getall.GetAllWorkerInteractor;
import org.reparationservice.usecases.worker.getall.GetAllWorkersResponder;

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
