package reparationservice.usecases.worker;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;

public interface AddWorkerInteractorFactory {
  public abstract UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers);
}
