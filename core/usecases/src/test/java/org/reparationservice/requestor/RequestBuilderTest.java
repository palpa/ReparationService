package org.reparationservice.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import org.reparationservice.requestor.impl.RequestBuilderImpl;
import org.reparationservice.usecases.worker.add.AddWorkerRequest;
import org.reparationservice.usecases.worker.add.AddWorkerRequestBuilder;
import org.reparationservice.usecases.worker.add.AddWorkerResponder;
import org.reparationservice.usecases.worker.add.AddWorkerResponderSpy;
import org.reparationservice.usecases.worker.getall.GetAllWorkersRequest;
import org.reparationservice.usecases.worker.getall.GetAllWorkersRequestBuilder;
import org.reparationservice.usecases.worker.getall.GetAllWorkersResponder;

public class RequestBuilderTest {
  private static final String WORKER_USERNAME = "username";

  @Test
  public void buildAddWorkerRequest() {
    AddWorkerRequestBuilder builder = new RequestBuilderImpl();
    AddWorkerResponder responder = new AddWorkerResponderSpy();
    UseCaseRequest request = builder.buildAddWorkerRequest(WORKER_USERNAME, responder);
    assertThat(request).isInstanceOf(AddWorkerRequest.class);
    AddWorkerRequest addWorkerReq = (AddWorkerRequest) request;
    assertThat(addWorkerReq.getUserName()).isEqualTo(WORKER_USERNAME);
    addWorkerReq.workerAlreadyExists();
    assertThat(((AddWorkerResponderSpy) responder).workerAlreadyExistsWasCalled()).isTrue();
  }

  @Test
  public void buildGetAllWorkersRequest() {
    GetAllWorkersRequestBuilder builder = new RequestBuilderImpl();
    GetAllWorkersResponder responder = null;
    UseCaseRequest request = builder.buildGetAllWorkersRequest(responder);
    assertThat(request).isInstanceOf(GetAllWorkersRequest.class);
  }
}
