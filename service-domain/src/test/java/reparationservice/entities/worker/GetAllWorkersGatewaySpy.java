package reparationservice.entities.worker;

import java.util.Collection;
import java.util.Collections;

public class GetAllWorkersGatewaySpy implements WorkerGateway {

  private boolean getAllWorkerCalled = false;

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
    return Collections.emptyList();
  }
}
