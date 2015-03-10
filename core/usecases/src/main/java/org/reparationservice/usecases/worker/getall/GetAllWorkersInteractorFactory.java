package org.reparationservice.usecases.worker.getall;

import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;

public interface GetAllWorkersInteractorFactory {
  UseCaseActivator makeGetAllWorkersInteractor(WorkerGateway workers);
}
