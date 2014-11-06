package org.reparationservice.rest.utils.doubles;

import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerRequestBuilder;

public class RequestBuilderStub implements AddWorkerRequestBuilder {
  private boolean buildCalled = false;
  private String username;

  @Override
  public UseCaseRequest buildAddWorkerRequest(String username) {
    this.buildCalled = true;
    this.username = username;
    return null;
  }

  public boolean wasAddWorkerRequestBuildCalled() {
    return buildCalled;
  }

  public boolean withArgs(String workerUsername) {
    return this.username.equals(workerUsername);
  }
}
