package org.reparationservice.usecases.worker.getall;

import java.util.ArrayList;
import java.util.Collection;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;

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
    allWorkersPresenter.bindModel(convertToDTOCollection(workerGateway.getAllWorkers()) );
  }

  private Collection<WorkerDTO> convertToDTOCollection(Iterable<Worker> workers) {
    Collection<WorkerDTO> workerDTOCollection = new ArrayList<>();  
    for (Worker worker : workers) {
      workerDTOCollection.add(new WorkerDTO(worker.getUserName()));
    }
    return workerDTOCollection;
  }

  public class WorkerGatewayNotNull extends RuntimeException {
    private static final long serialVersionUID = -2219845456935531878L;
  }

  public class PresenterNotNull extends RuntimeException {
    private static final long serialVersionUID = 2553548905696488214L;
  }
}
