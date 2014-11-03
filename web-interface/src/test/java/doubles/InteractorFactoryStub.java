package doubles;

import reparationservice.interactors.Interactor;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requests.Request;

public final class InteractorFactoryStub implements InteractorFactory {
  private String interactorName;
  private boolean executeCalled = false;

  @Override
  public Interactor make(String interactorName) {
    this.interactorName = interactorName;
    return new Interactor() {
      @Override
      public void execute(Request request) {
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
