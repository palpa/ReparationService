package reparationservice.usecases.worker;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;

public interface AddWorkerInteractorFactory {
  UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers);
}
