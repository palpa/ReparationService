package reparationservice.requestor.impl;

import reparationservice.requestor.RequestBuilder;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerRequest;

public class RequestBuilderImpl implements RequestBuilder {
  @Override
  public UseCaseRequest buildAddWorkerRequest(String username) {
    return new AddWorkerRequest(username);
  }
}
