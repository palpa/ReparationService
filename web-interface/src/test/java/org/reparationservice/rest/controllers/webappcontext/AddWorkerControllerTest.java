package org.reparationservice.rest.controllers.webappcontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;
import reparationservice.requests.AddWorkerRequest;

public class AddWorkerControllerTest extends ControllerTest {
  @Autowired
  WorkerGateway workerGW;

  @Test
  @DirtiesContext
  public void addWorker() throws Exception {
    String workerJson = json(new AddWorkerRequest("username"));

    assertThat(workerGW.getWorkerByUserName("username"))
        .isEqualTo(Worker.NULL);

    mockMvc.perform(
        post("/workers")
            .contentType(contentType)
            .content(workerJson))
        .andDo(print())
        .andExpect(status().isCreated());

    assertThat(workerGW.getWorkerByUserName("username").getUserName())
        .isEqualTo("username");
  }
}
