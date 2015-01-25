package org.reparationservice.datanucleus.entities.worker;

import org.junit.Test;
import org.reparationservice.datanucleus.DatanucleusConfigurator;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkerTest {
	private static final String USER_NAME = "UserName";

	@Test
	public void createWorker() {
		Worker worker = DatanucleusConfigurator.instance.getNewWorker(new WorkerDTO(USER_NAME));
		assertThat(worker).isNotNull();
		assertThat(worker.getUserName()).isEqualTo(USER_NAME);
	}
}
