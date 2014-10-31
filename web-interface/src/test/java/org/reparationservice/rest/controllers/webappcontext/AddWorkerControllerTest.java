package org.reparationservice.rest.controllers.webappcontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class AddWorkerControllerTest extends ControllerTest {
  private static final String WORKER_USERNAME = "username";
  @Autowired
  WorkerGateway workerGW;

  @Test
  @DirtiesContext
  public void addWorker() throws Exception {
    String workerJson = json(AddWorkerJsonRequest.newInstance(WORKER_USERNAME));

    assertThat(workerGW.getWorkerByUserName(WORKER_USERNAME))
        .isEqualTo(Worker.NULL);

    mockMvc.perform(
        post("/workers")
            .contentType(contentType)
            .content(workerJson))
        .andDo(print())
        .andExpect(status().isCreated());

    assertThat(workerGW.getWorkerByUserName(WORKER_USERNAME).getUserName())
        .isEqualTo(WORKER_USERNAME);
  }
}
