package reparationservice.usecases.worker.add;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public interface AddWorkerInteractorFactory {
  UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers, UseCaseRequest request);
}
