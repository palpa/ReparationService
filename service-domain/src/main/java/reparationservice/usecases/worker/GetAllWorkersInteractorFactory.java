package reparationservice.usecases.worker;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;

public interface GetAllWorkersInteractorFactory {
  UseCaseActivator makeGetAllWorkersInteractor(WorkerGateway workers,
      GetAllWorkersResponder getAllWorkersResponder);
}
