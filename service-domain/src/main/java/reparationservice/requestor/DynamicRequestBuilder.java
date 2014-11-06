package reparationservice.requestor;

import java.util.HashMap;

public interface DynamicRequestBuilder {
  public abstract UseCaseRequest build(String requestName, HashMap<String, Object> args);
}
