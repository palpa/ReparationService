package doubles;

import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseRequest;

public final class InteractorFactoryStub implements InteractorFactory {
  private String interactorName;
  private boolean executeCalled = false;

  @Override
  public UseCaseActivator make(String interactorName) {
    this.interactorName = interactorName;
    return new UseCaseActivator() {
      @Override
      public void execute(UseCaseRequest request) {
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

  public static InteractorFactoryStub newInstance() {
    return new InteractorFactoryStub();
  }
}
