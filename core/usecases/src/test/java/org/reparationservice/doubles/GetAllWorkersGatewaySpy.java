package org.reparationservice.doubles;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;

import java.util.ArrayList;
import java.util.Collection;

public class GetAllWorkersGatewaySpy implements WorkerGateway {
  public static int workerListSize = 1; 
  private final Collection<Worker> workerList;
  private boolean getAllWorkerCalled = false;
  
  public GetAllWorkersGatewaySpy() {
    workerList = new ArrayList<>();
    workerList.add(new Worker() {
      @Override
      public String getUserName() {
        return null;
      }
    });
  }

  @Override
  public void addWorker(WorkerDTO workerDTO) {
  }

  @Override
  public Worker getWorkerByUserName(String workerUserName) {
    return null;
  }

  public boolean getAllWorkersWasCalled() {
    return getAllWorkerCalled;
  }

  @Override
  public Collection<Worker> getAllWorkers() {
    this.getAllWorkerCalled = true;
    return workerList;
  }
}
