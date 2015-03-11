package org.reparationservice.doubles;

import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;

import java.util.Collection;

public class WorkerGatewaySpy implements WorkerGateway {
  private Worker worker = Worker.NULL;
  private int addWorkerCalledTimes = 0;

  @Override
  public void addWorker(final WorkerDTO workerDTO) {
    addWorkerCalledTimes++;
    this.worker = new Worker() {
      @Override
      public String getUserName() {
        return workerDTO.getUserName();
      }
    };
  }

  @Override
  public Worker getWorkerByUserName(String workerUserName) {
    return worker;
  }

  public boolean addWorkerWasCalled() {
    return (addWorkerCalledTimes > 0);
  }

  public Worker getWorker() {
    return worker;
  }

  @Override
  public Collection<Worker> getAllWorkers() {
    return null;
  }

  public int addWorkerCalledTimes() {
    return addWorkerCalledTimes;
  }
}
