package org.reparationservice.requestor.impl;

import org.reparationservice.requestor.RequestBuilder;
import org.reparationservice.requestor.UseCaseRequest;
import org.reparationservice.usecases.worker.add.AddWorkerRequest;
import org.reparationservice.usecases.worker.add.AddWorkerResponder;

public class RequestBuilderImpl implements RequestBuilder {
  @Override
  public UseCaseRequest buildAddWorkerRequest(String username, AddWorkerResponder responder) {
    return new AddWorkerRequest(username, responder);
  }
}
