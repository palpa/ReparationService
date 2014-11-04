package org.reparationservice.rest.controllers.standalone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.reparationservice.rest.controllers.AddWorkerController;
import org.reparationservice.rest.requestor.InteractorFactoryImpl;
import org.reparationservice.rest.requestor.RequestBuilderImpl;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.reparationservice.rest.utils.TestUtil;
import org.reparationservice.rest.utils.doubles.InteractorFactoryStub;
import org.reparationservice.rest.utils.doubles.RequestBuilderStub;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class AddWorkerCtrlTest {
  private static final String WORKER_USERNAME_1 = "username1";
  private static final String WORKER_USERNAME_2 = "username2";
  private static final MediaType JSON_HAL_CONTENT_TYPE = TestUtil.JSON_HAL_CONTENT_TYPE;
  private AddWorkerController addWorkerCtrl;
  private MockMvc mockMvc;
  private InteractorFactoryStub intFactoryStub;
  private RequestBuilderStub requestBuilderStub;

  @Before
  public void setup() throws Exception {
    intFactoryStub = InteractorFactoryStub.newInstance();
    requestBuilderStub = new RequestBuilderStub();
    addWorkerCtrl = new AddWorkerController(intFactoryStub, requestBuilderStub);
    mockMvc = MockMvcBuilders.standaloneSetup(addWorkerCtrl).build();
    sendWorkerPostRequestFor(WORKER_USERNAME_1);
  }

  @Test
  public void callToAddWorkerInteractor() throws Exception {
    assertThat(intFactoryStub.getCalledInteractorName()).isEqualTo(
        InteractorFactoryImpl.ADD_WORKER_INTERACTOR);
  }

  @Test
  public void createdRequest() throws Exception {
    assertThat(intFactoryStub.wasExecuteCalled()).isTrue();
  }

  @Test
  public void executeWasCalled() throws Exception {
    assertRequestFor(WORKER_USERNAME_1);
    sendWorkerPostRequestFor(WORKER_USERNAME_2);
    assertRequestFor(WORKER_USERNAME_2);
  }

  private void assertRequestFor(String workerUsername) {
    assertThat(requestBuilderStub.wasBuildCalled()).isTrue();
    assertThat(
        requestBuilderStub.withRequestName("AddWorkerRequest"))
        .isTrue();
    HashMap<String, Object> args = new HashMap<String, Object>();

    args.put(RequestBuilderImpl.USERNAME_PARAM_KEY, workerUsername);
    assertThat(
        requestBuilderStub.withArgs(args))
        .isTrue();
  }

  private void sendWorkerPostRequestFor(String username) throws Exception, IOException {
    mockMvc.perform(
        post("/workers")
            .contentType(JSON_HAL_CONTENT_TYPE)
            .content(getJsonWorkerReq(username)))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  private byte[] getJsonWorkerReq(String username) throws IOException {
    return TestUtil.object2JsonBytes(AddWorkerJsonRequest.newInstance(username));
  }
}
