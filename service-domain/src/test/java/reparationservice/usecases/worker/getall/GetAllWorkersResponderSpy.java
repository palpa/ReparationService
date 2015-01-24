package reparationservice.usecases.worker.getall;

import java.util.Collection;

import reparationservice.entities.worker.WorkerDTO;

public class GetAllWorkersResponderSpy implements GetAllWorkersResponder {
  private boolean bindModelCalled = false;
  private Collection<WorkerDTO> workerList;

  @Override
  public void bindModel(Collection<WorkerDTO> workerList) {
    bindModelCalled = true;
    this.workerList = workerList;
  }

  public boolean bindModelWasCalled() {
    return bindModelCalled;
  }

  public Collection<WorkerDTO> getWorkerCollection() {
    return this.workerList;
  }
}
