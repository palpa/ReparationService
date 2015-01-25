package org.reparationservice.entities.worker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class WorkerTest {
	private static final String EMPTY_USERNAME = "";
	private static final String USER_NAME = "UserName";
	
	@Test
	public void workerSpecialCase() {
		Worker worker = Worker.NULL;
		assertThat(worker).isNotNull();
		assertThat(worker.getUserName()).isEqualTo(EMPTY_USERNAME);
	}

	@Test
	public void testWorkerDTO() {
		WorkerDTO workerDTO= new WorkerDTO(USER_NAME);
		assertThat(workerDTO).isNotNull();
		assertThat(workerDTO.getUserName()).isEqualTo(USER_NAME);
	}
}
