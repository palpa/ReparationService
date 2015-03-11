package org.reparationservice.usecases.worker.add;

import org.reparationservice.requestor.UseCaseRequest;

public class AddWorkerRequest implements UseCaseRequest, AddWorkerResponder {
  private final AddWorkerResponder responder;
  private final String username;

  public AddWorkerRequest(String username, AddWorkerResponder responder) {
    this.username = username;
    this.responder = responder;
  }

  public String getUserName() {
    return username;
  }

  @Override public void workerAlreadyExists() {
    responder.workerAlreadyExists();
  }
}
