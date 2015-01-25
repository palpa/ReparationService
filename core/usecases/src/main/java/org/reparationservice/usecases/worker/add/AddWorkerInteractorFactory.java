package org.reparationservice.usecases.worker.add;

import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public interface AddWorkerInteractorFactory {
  UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers, UseCaseRequest request);
}
