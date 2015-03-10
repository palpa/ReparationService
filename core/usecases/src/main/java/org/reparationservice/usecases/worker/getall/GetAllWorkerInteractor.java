package org.reparationservice.usecases.worker.getall;

import java.util.ArrayList;
import java.util.Collection;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public class GetAllWorkerInteractor implements UseCaseActivator {
  private final WorkerGateway workerGateway;

  public GetAllWorkerInteractor(WorkerGateway workerGateway) {
    if (workerGateway == null)
      throw new WorkerGatewayCannotBeNull();

    this.workerGateway = workerGateway;
  }

  @Override
  public void execute(UseCaseRequest request) {
    if (request == null)
      throw new GetAllWorkersRequestCannotBeNull();
    GetAllWorkersRequest allWorkersReq = (GetAllWorkersRequest) request;

    Collection<WorkerDTO> workerList = convertToDTOCollection(workerGateway.getAllWorkers());
    allWorkersReq.bindModel(workerList);
  }

  private Collection<WorkerDTO> convertToDTOCollection(Iterable<Worker> workers) {
    Collection<WorkerDTO> workerDTOCollection = new ArrayList<>();  
    for (Worker worker : workers) {
      workerDTOCollection.add(new WorkerDTO(worker.getUserName()));
    }
    return workerDTOCollection;
  }

  class WorkerGatewayCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = -2219845456935531878L;
  }

  class GetAllWorkersRequestCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = -7825871272211962752L;
  }
}
