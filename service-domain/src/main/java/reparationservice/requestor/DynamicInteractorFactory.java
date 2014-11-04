package reparationservice.requestor;


public interface DynamicInteractorFactory {
  public abstract UseCaseActivator make(String interactorName);

  public class InteractorNotFound extends RuntimeException {
    private static final long serialVersionUID = -1309890475717132287L;

    public InteractorNotFound() {
      super("Interactor not found");
    }
  }
}
