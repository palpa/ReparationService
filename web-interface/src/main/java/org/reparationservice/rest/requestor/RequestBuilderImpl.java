package org.reparationservice.rest.requestor;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import reparationservice.interactors.requests.AddWorkerRequest;
import reparationservice.requestor.RequestBuilder;
import reparationservice.requestor.UseCaseRequest;

@Component
public class RequestBuilderImpl implements RequestBuilder {
  public static final String USERNAME_PARAM_KEY = "username";

  @Override
  public UseCaseRequest build(String requestName, HashMap<String, Object> args) {
    String username = (String) args.get(USERNAME_PARAM_KEY);
    return new AddWorkerRequest(username);
  }
}
