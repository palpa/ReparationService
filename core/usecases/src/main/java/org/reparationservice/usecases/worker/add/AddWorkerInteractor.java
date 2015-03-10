package org.reparationservice.usecases.worker.add;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public final class AddWorkerInteractor implements UseCaseActivator {
  private final WorkerGateway workers;
  private final AddWorkerRequest request;

  public AddWorkerInteractor(WorkerGateway workers, UseCaseRequest request) {
    this.workers = workers;
    this.request = (AddWorkerRequest) request;
  }

  @Override
  public void execute(UseCaseRequest request) {
    String workerUserName = this.request.getUserName();

    if (workers.getWorkerByUserName(workerUserName) != Worker.NULL)
      this.request.workerAlreadyExists();
    else
      workers.addWorker(new WorkerDTO(workerUserName));
  }
}
