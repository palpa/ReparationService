package org.reparationservice.rest.utils.doubles;

import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.DynamicInteractorFactory;

public final class DynamicInteractorFactoryStub implements DynamicInteractorFactory {
  private String interactorName;
  private boolean executeCalled = false;

  @Override
  public UseCaseActivator make(String interactorName) {
    this.interactorName = interactorName;
    return new UseCaseActivator() {
      @Override
      public void execute() {
        executeCalled = true;
      }
    };
  }

  public String getCalledInteractorName() {
    return interactorName;
  }
  
  public boolean wasExecuteCalled() {
    return executeCalled;
  }

  public static DynamicInteractorFactoryStub newInstance() {
    return new DynamicInteractorFactoryStub();
  }
}
