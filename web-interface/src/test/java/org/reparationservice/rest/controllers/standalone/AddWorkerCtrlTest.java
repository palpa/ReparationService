package org.reparationservice.rest.controllers.standalone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.reparationservice.rest.controllers.AddWorkerController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import reparationservice.Configurator;
import reparationservice.gateways.WorkerGateway;

public class AddWorkerCtrlTest {
  
  private final MediaType contentType = new MediaType(
      "application", "hal+json");

 // @InjectMocks
  private AddWorkerController addWorkerCtrl;

  private MockMvc mockMvc;

  private WorkerGateway workerGW;

  @Before
  public void setup() {
    // Process mock annotations
   // MockitoAnnotations.initMocks(this);

    workerGW = Configurator.getWorkerGateway();
    addWorkerCtrl = new AddWorkerController(workerGW);
    
    // Setup Spring test in standalone mode
    this.mockMvc = MockMvcBuilders.standaloneSetup(addWorkerCtrl).build();
  }

  @Test
  public void addWorker() throws Exception {
    mockMvc.perform(
        post("/workers")
            .contentType(contentType)
            .content(""))
        .andDo(print())
        .andExpect(status().isCreated());
  }
  
}
