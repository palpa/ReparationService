package org.reparationservice.doubles;

import java.util.Collection;

import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.usecases.worker.getall.GetAllWorkersResponder;

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
