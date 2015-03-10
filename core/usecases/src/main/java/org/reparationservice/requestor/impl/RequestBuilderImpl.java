package org.reparationservice.requestor.impl;

import org.reparationservice.requestor.RequestBuilder;
import org.reparationservice.requestor.UseCaseRequest;
import org.reparationservice.usecases.worker.add.AddWorkerRequest;
import org.reparationservice.usecases.worker.add.AddWorkerResponder;
import org.reparationservice.usecases.worker.getall.GetAllWorkersRequest;
import org.reparationservice.usecases.worker.getall.GetAllWorkersRequestBuilder;
import org.reparationservice.usecases.worker.getall.GetAllWorkersResponder;

public class RequestBuilderImpl implements RequestBuilder, GetAllWorkersRequestBuilder {
  @Override
  public UseCaseRequest buildAddWorkerRequest(String username, AddWorkerResponder responder) {
    return new AddWorkerRequest(username, responder);
  }

  @Override public UseCaseRequest buildGetAllWorkersRequest(GetAllWorkersResponder responder) {
    return new GetAllWorkersRequest(responder);
  }
}
