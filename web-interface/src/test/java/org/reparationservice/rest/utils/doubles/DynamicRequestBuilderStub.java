package org.reparationservice.rest.utils.doubles;

import java.util.HashMap;

import reparationservice.requestor.RequestBuilder;
import reparationservice.requestor.UseCaseRequest;

public class DynamicRequestBuilderStub implements RequestBuilder {
  private String requestName;
  private HashMap<String, Object> args;
  private boolean buildCalled = false;

  @Override
  public UseCaseRequest build(String requestName, HashMap<String, Object> args) {
    this.requestName = requestName;;
    this.args = args;
    buildCalled = true;
    return new UseCaseRequest() {};
  }
  
  public boolean wasBuildCalled() {
    return buildCalled;
  }

  public boolean withRequestName(String requestName) {
    return this.requestName.equals(requestName);
  }
  public boolean withArgs(HashMap<String, Object> args) {
    return this.args.equals(args);
  }
}
