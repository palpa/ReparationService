package org.reparationservice.rest.controllers.standalone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.reparationservice.rest.controllers.AddWorkerController;
import org.reparationservice.rest.controllers.standalone.helpers.TestHelper;
import org.reparationservice.rest.controllers.standalone.helpers.doubles.AddWorkerInteractorFactoryStub;
import org.reparationservice.rest.controllers.standalone.helpers.doubles.AddWorkerRequestBuilderStub;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.entities.worker.WorkerGatewaySpy;

public class AddWorkerCtrlTest {
  private static final String WORKER_USERNAME_1 = "username1";
  private static final String WORKER_USERNAME_2 = "username2";
  private static final MediaType JSON_HAL_CONTENT_TYPE = TestHelper.JSON_HAL_CONTENT_TYPE;
  private MockMvc mockMvc;
  private AddWorkerInteractorFactoryStub intFactoryStub;
  private AddWorkerRequestBuilderStub requestBuilderStub;
  private WorkerGateway workerGW;

  @Before
  public void setup() throws Exception {
    intFactoryStub = AddWorkerInteractorFactoryStub.newInstance();
    requestBuilderStub = new AddWorkerRequestBuilderStub();
    workerGW = new WorkerGatewaySpy();
    AddWorkerController addWorkerCtrl = new AddWorkerController(intFactoryStub, workerGW, requestBuilderStub);
    mockMvc = MockMvcBuilders.standaloneSetup(addWorkerCtrl).build();
    sendWorkerPostRequestFor(WORKER_USERNAME_1);
  }

  @Test
  public void callToAddWorkerInteractorWithGivenGW() throws Exception {
    assertThat(intFactoryStub.wasMakeAddWorkerInteractorCalled()).isTrue();
    assertThat(intFactoryStub.getWorkerGateway()).isInstanceOf(workerGW.getClass());
  }

  @Test
  public void createdRequest() throws Exception {
    assertRequestFor(WORKER_USERNAME_1);
    sendWorkerPostRequestFor(WORKER_USERNAME_2);
    assertRequestFor(WORKER_USERNAME_2);
  }

  @Test
  public void executeWasCalled() throws Exception {
    assertThat(intFactoryStub.wasExecuteCalled()).isTrue();
  }

  private void assertRequestFor(String workerUsername) {
    assertThat(requestBuilderStub.wasAddWorkerRequestBuildCalled()).isTrue();
    assertThat(requestBuilderStub.withArgs(workerUsername)).isTrue();
  }

  private void sendWorkerPostRequestFor(String username) throws Exception {
    mockMvc.perform(
        post("/workers")
            .contentType(JSON_HAL_CONTENT_TYPE)
            .content(getJsonWorkerReq(username)))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  private byte[] getJsonWorkerReq(String username) throws IOException {
    return TestHelper.object2JsonBytes(AddWorkerJsonRequest.newInstance(username));
  }
}
