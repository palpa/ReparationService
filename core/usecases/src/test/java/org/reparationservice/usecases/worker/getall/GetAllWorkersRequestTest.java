package org.reparationservice.usecases.worker.getall;

import org.junit.Test;
import org.reparationservice.doubles.GetAllWorkersResponderSpy;
import org.reparationservice.entities.worker.WorkerDTO;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllWorkersRequestTest {
  @Test
  public void requestIsInstanceOfGetAllWorkersResponder() {
    GetAllWorkersResponder responder = new GetAllWorkersResponderSpy();
    GetAllWorkersRequest request = new GetAllWorkersRequest(responder);

    assertThat(request).isInstanceOf(GetAllWorkersResponder.class);
  }

  @Test
  public void bindModelWasCalled() {
    GetAllWorkersResponder responder = new GetAllWorkersResponderSpy();
    GetAllWorkersRequest request = new GetAllWorkersRequest(responder);

    Collection<WorkerDTO> workerList = null;
    request.bindModel(workerList);

    GetAllWorkersResponderSpy respSpy = (GetAllWorkersResponderSpy) responder;
    assertThat(respSpy.bindModelWasCalled()).isTrue();
  }

}
