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
    this.getAllWorkerCalled = true;
    return getAllWorkerCalled;
  }

  @Override
  public List<Worker> getAllWorkers() {
    return new ArrayList<Worker>();
  }
}
