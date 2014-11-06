package org.reparationservice.rest.requestor;

import org.springframework.stereotype.Component;

import reparationservice.requestor.RequestBuilder;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerRequest;

@Component
public class RequestBuilderImpl implements RequestBuilder {
  @Override
  public UseCaseRequest buildAddWorkerRequest(String username) {
    return new AddWorkerRequest(username);
  }
}
