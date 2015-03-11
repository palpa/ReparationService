package org.reparationservice.usecases.worker.getall;

import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.requestor.UseCaseRequest;

import java.util.Collection;

public class GetAllWorkersRequest implements UseCaseRequest, GetAllWorkersResponder {
  private final GetAllWorkersResponder responder;

  public GetAllWorkersRequest(GetAllWorkersResponder responder) {
    this.responder = responder;
  }

  @Override public void bindModel(Collection<WorkerDTO> workerList) {
    responder.bindModel(workerList);
  }
}
