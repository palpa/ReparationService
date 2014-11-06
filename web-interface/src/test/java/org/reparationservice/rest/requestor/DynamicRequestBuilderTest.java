package org.reparationservice.rest.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Test;

import reparationservice.requestor.DynamicRequestBuilder;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerRequest;

public class DynamicRequestBuilderTest {
  private static final String USERNAME_PARAM_KEY = "username";
  private static final String WORKER_USERNAME = "any username";
  

  @Test
  public void buildAddWorkerRequest() {
    DynamicRequestBuilder reqBuilder = new DynamicRequestBuilderImpl();
    String requestName = "AddWorkerRequest";
    HashMap<String, Object> args = new HashMap<String, Object>();
    args.put(USERNAME_PARAM_KEY, WORKER_USERNAME);
    UseCaseRequest request = reqBuilder.build(requestName , args);
   
    assertThat(request).isInstanceOf(AddWorkerRequest.class);
    assertThat(((AddWorkerRequest)request).getUserName()).isEqualTo(WORKER_USERNAME);
  }
}
