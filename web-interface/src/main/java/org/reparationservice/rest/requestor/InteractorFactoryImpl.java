package org.reparationservice.rest.requestor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.InteractorFactory;
import reparationservice.usecases.worker.AddWorkerInteractor;

@Component
public class InteractorFactoryImpl implements InteractorFactory {
  public static final String ADD_WORKER_INTERACTOR = "AddWorkerInteractor";
  private WorkerGateway workerGW;

  @Autowired
  public InteractorFactoryImpl(WorkerGateway workerGW) {
    this.workerGW = workerGW;
  }

  @Override
  public UseCaseActivator make(String interactorName) {
    if (interactorName == ADD_WORKER_INTERACTOR)
      return new AddWorkerInteractor(workerGW);
    throw new InteractorNotFound();
  }
}
