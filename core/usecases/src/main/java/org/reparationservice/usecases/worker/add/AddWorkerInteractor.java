package org.reparationservice.usecases.worker.add;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public final class AddWorkerInteractor implements UseCaseActivator {
  private final WorkerGateway workers;

  public AddWorkerInteractor(WorkerGateway workers) {
    this.workers = workers;
  }

  @Override
  public void execute(UseCaseRequest request) {
    AddWorkerRequest addWorkerReq = (AddWorkerRequest) request;
    String workerUserName = addWorkerReq.getUserName();

    if (workers.getWorkerByUserName(workerUserName) != Worker.NULL)
      addWorkerReq.workerAlreadyExists();
    else
      workers.addWorker(new WorkerDTO(workerUserName));
  }
}
