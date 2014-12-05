package org.reparationservice.rest.requestor;

import org.springframework.stereotype.Component;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerInteractor;
import reparationservice.usecases.worker.GetAllWorkerInteractor;
import reparationservice.usecases.worker.GetAllWorkersResponder;

@Component
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
