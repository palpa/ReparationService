package org.reparationservice.usecases.worker.add;

public class AddWorkerResponderSpy implements AddWorkerResponder {

  private boolean wasCalled = false;

  @Override
  public void workerAlreadyExists() {
    wasCalled = true;
  }

  public boolean workerAlreadyExistsWasCalled() {
    return wasCalled;
  }
}
