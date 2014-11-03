package org.reparationservice.rest.requestor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reparationservice.gateways.WorkerGateway;
import reparationservice.interactors.AddWorkerInteractor;
import reparationservice.interactors.Interactor;
import reparationservice.requestor.InteractorFactory;

@Component
public class InteractorFactoryImpl implements InteractorFactory {
  public static final String ADD_WORKER_INTERACTOR = "AddWorkerInteractor";
  private WorkerGateway workerGW;

  @Autowired
  public InteractorFactoryImpl(WorkerGateway workerGW) {
    this.workerGW = workerGW;
  }

  @Override
  public Interactor make(String interactorName) {
    if (interactorName == ADD_WORKER_INTERACTOR)
      return new AddWorkerInteractor(workerGW);
    throw new InteractorNotFound();
  }
}
