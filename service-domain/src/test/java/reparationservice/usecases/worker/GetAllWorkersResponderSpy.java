package reparationservice.usecases.worker;

import java.util.List;

import reparationservice.entities.worker.Worker;

public class GetAllWorkersResponderSpy implements GetAllWorkersResponder {
  private List<Worker> workerList;
  private boolean bindModelCalled = false;

  @Override
  public List<Worker> getModel() {
    return workerList;
  }

  @Override
  public void bindModel(List<Worker> workerList) {
    bindModelCalled = true;
    this.workerList = workerList;
  }

  public boolean bindModelWasCalled() {
    return bindModelCalled ;
  }
}
