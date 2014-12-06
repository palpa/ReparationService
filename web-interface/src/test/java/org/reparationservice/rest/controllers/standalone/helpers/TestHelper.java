package org.reparationservice.rest.controllers.standalone.helpers;

import java.io.IOException;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestHelper {
  public static final MediaType JSON_HAL_CONTENT_TYPE = new MediaType("application", "hal+json");

  public static byte[] object2JsonBytes(Object object) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper.writeValueAsBytes(object);
  }
}
