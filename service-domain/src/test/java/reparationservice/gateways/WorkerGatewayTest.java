package reparationservice.gateways;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class WorkerGatewayTest {
	private static final String WORKER_USER_NAME_1 = "UserName1";
	private static final String WORKER_USER_NAME_2 = "UserName2";
	private WorkerGateway workers;

	@Before
	public void setUp() {
		workers = new ReparationService();
	}

	@Test
	public void returnNullWorkerWhenWorkerNotFound() {
		assertThat(workers.getWorkerByUserName(WORKER_USER_NAME_1))
				.isEqualTo(Worker.NULL);
	}

	@Test
	public void addWorkerToReparationService() {
		workers.addWorker(newWorker(WORKER_USER_NAME_1));
		workers.addWorker(newWorker(WORKER_USER_NAME_2));

		Worker worker1 = workers
				.getWorkerByUserName(WORKER_USER_NAME_1);
		assertThat(worker1.getUserName()).isEqualTo(WORKER_USER_NAME_1);

		Worker worker2 = workers
				.getWorkerByUserName(WORKER_USER_NAME_2);
		assertThat(worker2.getUserName()).isEqualTo(WORKER_USER_NAME_2);
	}

	private Worker newWorker(String userName) {
		return Worker.newInstance(userName);
	}
}
