package reparationservice.usecases.worker.getall;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;

public class GetAllWorkerInteractor implements UseCaseActivator {
  private final GetAllWorkersResponder allWorkersPresenter;
  private final WorkerGateway workerGateway;

  public GetAllWorkerInteractor(WorkerGateway workerGateway,
      GetAllWorkersResponder allWorkersPresenter) {
    if (workerGateway == null)
      throw new WorkerGatewayNotNull();
    if (allWorkersPresenter == null)
      throw new PresenterNotNull();
    this.workerGateway = workerGateway;
    this.allWorkersPresenter = allWorkersPresenter;
  }

  @Override
  public void execute() {
    allWorkersPresenter.bindModel(workerGateway.getAllWorkers());
  }

  public class WorkerGatewayNotNull extends RuntimeException {
    private static final long serialVersionUID = -2219845456935531878L;
  }

  public class PresenterNotNull extends RuntimeException {
    private static final long serialVersionUID = 2553548905696488214L;
  }
}
