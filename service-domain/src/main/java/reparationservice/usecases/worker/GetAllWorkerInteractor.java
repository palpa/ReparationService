package reparationservice.usecases.worker;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public class GetAllWorkerInteractor implements UseCaseActivator {
  private final GetAllWorkersResponder allWorkersPresenter;
  private final WorkerGateway workerGateway;

  public GetAllWorkerInteractor(WorkerGateway workerGateway,
      GetAllWorkersResponder allWorkersPresenter) {
    this.workerGateway = workerGateway;
    this.allWorkersPresenter = allWorkersPresenter;
  }

  @Override
  public void execute(UseCaseRequest request) {
    allWorkersPresenter.bindModel(workerGateway.getAllWorkers());
  }
}
