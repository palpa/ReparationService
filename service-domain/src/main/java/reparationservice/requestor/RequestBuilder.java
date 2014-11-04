package reparationservice.requestor;

import java.util.HashMap;

public interface RequestBuilder {
  public abstract UseCaseRequest build(String requestName, HashMap<String, Object> args);
}
