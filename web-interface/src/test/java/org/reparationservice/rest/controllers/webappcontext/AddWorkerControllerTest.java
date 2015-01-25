package org.reparationservice.rest.controllers.webappcontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.ResultMatcher;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AddWorkerControllerTest extends ControllerTest {
  private static final String WORKERS_URI = "/workers";
  private static final String WORKER_USERNAME = "username";
  private static final ResultMatcher CONFLICT_STATUS_EXPECTED = status().isConflict();
  private static final ResultMatcher CREATED_STATUS_EXPECTED = status().isCreated();

  @Autowired
  private WorkerGateway workerGW;

  @Test
  public void successfulWorkerCreation() throws Exception {
    assertThat(workerGW.getWorkerByUserName(WORKER_USERNAME))
        .isEqualTo(Worker.NULL);

    sendWorkerPostRequestFor(WORKER_USERNAME, CREATED_STATUS_EXPECTED);

    assertThat(workerGW.getWorkerByUserName(WORKER_USERNAME).getUserName())
        .isEqualTo(WORKER_USERNAME);
  }

  @Test
  public void returnErrorTryingToAddAnExistingWorker() throws Exception {
    sendWorkerPostRequestFor(WORKER_USERNAME, CREATED_STATUS_EXPECTED);
    sendWorkerPostRequestFor(WORKER_USERNAME, CONFLICT_STATUS_EXPECTED);
  }

  private void sendWorkerPostRequestFor(String username, ResultMatcher expectedStatus)
      throws Exception {
    String workerJson = json(AddWorkerJsonRequest.newInstance(username));
    mockMvc.perform(
        post(WORKERS_URI)
            .contentType(contentType)
            .content(workerJson))
        .andDo(print())
        .andExpect(expectedStatus);
  }
}
