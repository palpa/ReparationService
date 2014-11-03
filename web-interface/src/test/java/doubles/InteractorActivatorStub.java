package doubles;

import org.reparationservice.rest.requestor.InteractorFactory;

import reparationservice.interactors.Interactor;
import reparationservice.requests.Request;

public final class InteractorActivatorStub implements InteractorFactory {
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

  public static InteractorActivatorStub newInstance() {
    return new InteractorActivatorStub();
  }
}
