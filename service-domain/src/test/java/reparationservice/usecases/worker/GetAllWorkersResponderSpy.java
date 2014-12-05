package reparationservice.usecases.worker;

import reparationservice.entities.worker.Worker;

public class GetAllWorkersResponderSpy implements GetAllWorkersResponder {
  private boolean bindModelCalled = false;

  @Override
  public void bindModel(Iterable<Worker> workerList) {
    bindModelCalled = true;
  }

  public boolean bindModelWasCalled() {
    return bindModelCalled ;
  }
}
