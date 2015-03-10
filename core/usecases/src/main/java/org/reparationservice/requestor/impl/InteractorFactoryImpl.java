package org.reparationservice.requestor.impl;

import org.reparationservice.requestor.InteractorFactory;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.usecases.worker.add.AddWorkerInteractor;
import org.reparationservice.usecases.worker.getall.GetAllWorkerInteractor;

public class InteractorFactoryImpl implements InteractorFactory {
  @Override
  public UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers) {
    return new AddWorkerInteractor(workers);
  }

  @Override
  public UseCaseActivator makeGetAllWorkersInteractor(WorkerGateway workers) {
    return new GetAllWorkerInteractor(workers);
  }
}
