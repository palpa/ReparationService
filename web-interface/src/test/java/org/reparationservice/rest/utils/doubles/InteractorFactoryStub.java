package org.reparationservice.rest.utils.doubles;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public class InteractorFactoryStub extends InteractorFactory{
  protected boolean executeCalled;
  private boolean makeAddWorkerInteractorCalled = false;
  private WorkerGateway workers;

  @Override
  public UseCaseActivator makeAddWorkerInteractor(WorkerGateway workers) {
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
  
  public static InteractorFactoryStub newInstance() {
    return new InteractorFactoryStub();
  }
  
  private final class InteractorStub implements UseCaseActivator {
    @Override
    public void execute(UseCaseRequest request) {
      executeCalled = true;
    }
  }
}
