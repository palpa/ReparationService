package org.reparationservice.rest.controllers.webappcontext;

import static org.springframework.test.annotation.DirtiesContext.ClassMode;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.ResultMatcher;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class GetAllWorkersControllerTest extends ControllerTest {
  private static final String WORKERS_URI = "/workers";
  private static final String WORKER_USERNAME = "any username";
  private static final ResultMatcher OK_STATUS_EXPECTED = status().isOk();

  @Autowired
  private WorkerGateway workerGW;

  @Test
  public void successfulWorkerCreation() throws Exception {
    workerGW.addWorker(new WorkerDTO(WORKER_USERNAME));
    mockMvc.perform(
        get(WORKERS_URI))
        .andDo(print())
        .andExpect(content().contentType(contentType))
        .andExpect(OK_STATUS_EXPECTED)
        .andExpect(jsonPath("$._embedded.workerDTOList[0].userName", equalTo(WORKER_USERNAME)));
  }
}
