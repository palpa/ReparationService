package org.reparationservice.rest.controllers.webappcontext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class AdditionalTest extends ControllerTest {
  @Test
  public void returnNotFoundErrorWhenPostToWrongPath() throws Exception {
    mockMvc.perform(post("/wrong/path")
        .contentType(contentType))
        .andDo(print())
        .andExpect(status().isNotFound());
  }
}
