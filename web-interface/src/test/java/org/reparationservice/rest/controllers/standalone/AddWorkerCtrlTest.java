package org.reparationservice.rest.controllers.standalone;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.reparationservice.rest.controllers.AddWorkerController;
import org.reparationservice.rest.controllers.standalone.helpers.TestHelper;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.usecases.worker.add.AddWorkerInteractorFactory;
import reparationservice.usecases.worker.add.AddWorkerRequestBuilder;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

@RunWith(MockitoJUnitRunner.class)
public class AddWorkerCtrlTest {
  private static final String WORKER_USERNAME_1 = "any username 1";
  private static final String WORKER_USERNAME_2 = "any username 2";
  private static final MediaType JSON_HAL_CONTENT_TYPE = TestHelper.JSON_HAL_CONTENT_TYPE;
  private MockMvc mockMvc;
  @Mock
  private AddWorkerInteractorFactory addWorkerIF;
  @Mock
  private AddWorkerRequestBuilder addWorkerRB;
  @Mock
  private WorkerGateway workerGW;
  @Mock
  private UseCaseActivator interactor;

  @Before
  public void setup() throws Exception {
    when(addWorkerIF.makeAddWorkerInteractor(any(WorkerGateway.class), any(UseCaseRequest.class)))
        .thenReturn(interactor);

    AddWorkerController addWorkerCtrl = new AddWorkerController(addWorkerIF, workerGW, addWorkerRB);
    mockMvc = MockMvcBuilders.standaloneSetup(addWorkerCtrl).build();

    sendWorkerPostRequestFor(WORKER_USERNAME_1);
  }

  @Test
  public void callToAddWorkerInteractorWithGivenGW() throws Exception {
    ArgumentCaptor<WorkerGateway> wGwArg = ArgumentCaptor.forClass(WorkerGateway.class);
    verify(addWorkerIF, times(1)).makeAddWorkerInteractor(wGwArg.capture(),
        any(UseCaseRequest.class));

    assertThat(wGwArg.getValue()).isSameAs(workerGW);
  }

  @Test
  public void interactorActionWasExecuted() throws Exception {
    verify(interactor).execute();
  }

  @Test
  public void moreThanOneRequest() throws Exception {
    sendWorkerPostRequestFor(WORKER_USERNAME_2);
    
    ArgumentCaptor<String> usernameArg = ArgumentCaptor.forClass(String.class);
    verify(addWorkerRB, times(2)).buildAddWorkerRequest(usernameArg.capture());
    
    List<String> unernames = usernameArg.getAllValues();
    assertThat(unernames.get(0)).isEqualTo(WORKER_USERNAME_1);
    assertThat(unernames.get(1)).isEqualTo(WORKER_USERNAME_2);
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
