package org.reparationservice.rest.requestor;

import reparationservice.interactors.Interactor;

public interface InteractorFactory {
  public abstract Interactor make(String interactorName);

  public class InteractorNotFound extends RuntimeException {
    private static final long serialVersionUID = -1309890475717132287L;

    public InteractorNotFound() {
      super("Interactor not found");
    }
  }
}
