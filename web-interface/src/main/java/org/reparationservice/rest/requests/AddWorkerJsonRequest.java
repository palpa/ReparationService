package org.reparationservice.rest.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddWorkerJsonRequest {
  private final String username;
  
  @JsonCreator
  public static AddWorkerJsonRequest newInstance(@JsonProperty("username") String username) {
    return new AddWorkerJsonRequest(username);
  }
  
  public String getUsername() {
    return username;
  }

  private AddWorkerJsonRequest(String username) {
		this.username = username;
	}
}
