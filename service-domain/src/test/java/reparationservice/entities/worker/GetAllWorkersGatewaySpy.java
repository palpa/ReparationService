package reparationservice.entities.worker;

import java.util.ArrayList;
import java.util.List;

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
  public List<Worker> getAllWorkers() {
    this.getAllWorkerCalled = true;
    return new ArrayList<>();
  }
}
