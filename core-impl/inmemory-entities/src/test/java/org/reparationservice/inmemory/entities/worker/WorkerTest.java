package org.reparationservice.inmemory.entities.worker;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;
import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(HierarchicalContextRunner.class)
public class WorkerTest {
	private static final String USER_NAME = "UserName";

	@Test
	public void createWorker() {
		Worker worker = InMemoryConfigurator.getNewWorker(new WorkerDTO(USER_NAME));
		assertThat(worker).isNotNull();
		assertThat(worker.getUserName()).isEqualTo(USER_NAME);
	}
}
