package org.reparationservice.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;

public class AddWorkerControllerTest extends ControllerTest {
	@Test
	public void addWorker() throws Exception {
		String workerJson = json(new Worker("username"));
		mockMvc.perform(
				post("/workers")
						.contentType(contentType)
						.content(workerJson))
				.andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	public void NotFoundWhenAddWorkerOnWrongPath() throws Exception {
		String workerJson = json(new Worker("username"));
		mockMvc.perform(post("/wrong/path")
				.contentType(contentType)
				.content(workerJson))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	static class Worker {
		private final String username;

		public Worker(String username) {
			this.username = username;
		}

		public String getUsername() {
			return username;
		}
	}
}
