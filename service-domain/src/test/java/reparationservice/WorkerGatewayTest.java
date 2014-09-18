package reparationservice;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class WorkerGatewayTest {
	private static final String WORKER_USER_NAME_1 = "UserName1";
	private static final String WORKER_USER_NAME_2 = "UserName2";
	private WorkerGateway workerGateway;

	@Before
	public void setUp() {
		workerGateway = new ReparationService();
	}

	@Test
	public void addWorkerToReparationService() {
		workerGateway.addWorker(newWorker1());
		workerGateway.addWorker(newWorker2());

		Worker worker1 = workerGateway
				.getWorkerByUserName(WORKER_USER_NAME_1);
		assertThat(worker1.getUserName()).isEqualTo(WORKER_USER_NAME_1);

		Worker worker2 = workerGateway
				.getWorkerByUserName(WORKER_USER_NAME_2);
		assertThat(worker2.getUserName()).isEqualTo(WORKER_USER_NAME_2);
	}

	@Test(expected = WorkerGateway.WorkerAlreadyExists.class)
	public void throwWorkerAlreadyExistsWhenTwoWorkersWithSameUserNameAdded() {
		workerGateway.addWorker(newWorker1());
		workerGateway.addWorker(newWorker1());
	}

	@Test
	public void returnNullWhenWorkerNotFound() {
		assertThat(workerGateway.getWorkerByUserName(WORKER_USER_NAME_2))
				.isNull();
	}

	private Worker newWorker1() {
		return Worker.newInstance(WORKER_USER_NAME_1);
	}

	private Worker newWorker2() {
		return Worker.newInstance(WORKER_USER_NAME_2);
	}
}
