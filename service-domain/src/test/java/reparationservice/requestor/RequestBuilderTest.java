package reparationservice.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import reparationservice.requestor.UseCaseRequest;
import reparationservice.requestor.impl.RequestBuilderImpl;
import reparationservice.usecases.worker.AddWorkerRequest;
import reparationservice.usecases.worker.AddWorkerRequestBuilder;

public class RequestBuilderTest {
  private static final String WORKER_USERNAME = "username";

  @Test
  public void buildAddWorkerRequest() {
    AddWorkerRequestBuilder builder = new RequestBuilderImpl();
    UseCaseRequest request = builder.buildAddWorkerRequest(WORKER_USERNAME);
    assertThat(request).isInstanceOf(AddWorkerRequest.class);
    assertThat(((AddWorkerRequest) request).getUserName()).isEqualTo(WORKER_USERNAME);
  }
}
