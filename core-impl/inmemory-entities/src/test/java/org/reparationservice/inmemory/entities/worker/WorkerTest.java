package org.reparationservice.inmemory.entities.worker;

import org.junit.Test;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.inmemory.InMemoryConfigurator;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkerTest {
	private static final String USER_NAME = "UserName";

	@Test
	public void createWorker() {
		Worker worker = InMemoryConfigurator.getNewWorker(new WorkerDTO(USER_NAME));
		assertThat(worker).isNotNull();
		assertThat(worker.getUserName()).isEqualTo(USER_NAME);
	}
}
