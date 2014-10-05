package reparationservice.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class WorkerTests {
	private static final String WORKER_USER_NAME = "UserName";
	private Worker workerX;

	@Before
	public void setUp() throws Exception {
		workerX = getNewWorker();
	}

	private Worker getNewWorker() {
		return Worker.newInstance(WORKER_USER_NAME);
	}

	@Test
	public void createWorker() {
		assertThat(workerX).isNotNull();
	}

	@Test
	public void getWorkerUserName() {
		assertThat(workerX.getUserName()).isEqualTo(WORKER_USER_NAME);
	}
}
