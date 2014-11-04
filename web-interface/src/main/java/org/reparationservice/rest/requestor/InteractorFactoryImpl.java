package org.reparationservice.rest.requestor;

import org.springframework.stereotype.Component;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.usecases.worker.AddWorkerInteractor;

@Component
public class InteractorFactoryImpl extends InteractorFactory {
  @Override
  public UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers) {
    return new AddWorkerInteractor(workers);
  }
}
