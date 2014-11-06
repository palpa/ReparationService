package org.reparationservice.rest.requestor;

import org.springframework.stereotype.Component;

import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerRequest;
import reparationservice.usecases.worker.AddWorkerRequestBuilder;

@Component
public class RequestBuilder implements AddWorkerRequestBuilder {
  @Override
  public UseCaseRequest buildAddWorkerRequest(String username) {
    return new AddWorkerRequest(username);
  }
}
