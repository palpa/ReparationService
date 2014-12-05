package org.reparationservice.rest.utils.doubles;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerInteractorFactory;

public class AddWorkerInteractorFactoryStub implements AddWorkerInteractorFactory {
  protected boolean executeCalled;
  private boolean makeAddWorkerInteractorCalled = false;
  private WorkerGateway workers;

  @Override
  public UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers, UseCaseRequest request) {
    this.makeAddWorkerInteractorCalled = true;
    this.workers = workers;
    return new InteractorStub();
  }

  public boolean wasMakeAddWorkerInteractorCalled() {
    return makeAddWorkerInteractorCalled;
  }

  public WorkerGateway getWorkerGateway() {
    return workers;
  }

  public boolean wasExecuteCalled() {
    return executeCalled;
  }

  public static AddWorkerInteractorFactoryStub newInstance() {
    return new AddWorkerInteractorFactoryStub();
  }

  private final class InteractorStub implements UseCaseActivator {
    @Override
    public void execute() {
      executeCalled = true;
    }
  }
}
