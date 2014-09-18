package reparationservice;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.Worker;

public class ReparationServiceTests {
	private static final String WORKER_USER_NAME_1 = "UserName1";
	private static final String WORKER_USER_NAME_2 = "UserName2";
	private ReparationService reparationService;

	@Before
	public void setUp() {
		reparationService = new ReparationService();
	}

	@Test
	public void addWorkerToReparationService() {
		reparationService.add(newWorker1());
		reparationService.add(newWorker2());

		Worker worker1 = reparationService
				.getWorkerByUserName(WORKER_USER_NAME_1);
		assertThat(worker1.getUserName()).isEqualTo(WORKER_USER_NAME_1);

		Worker worker2 = reparationService
				.getWorkerByUserName(WORKER_USER_NAME_2);
		assertThat(worker2.getUserName()).isEqualTo(WORKER_USER_NAME_2);
	}

	@Test(expected = ReparationService.WorkerAlreadyExists.class)
	public void throwWorkerAlreadyExistsWhenTwoWorkersWithSameUserNameAdded() {
		reparationService.add(newWorker1());
		reparationService.add(newWorker1());
	}

	@Test
	public void returnNullWhenWorkerNotFound() {
		assertThat(reparationService.getWorkerByUserName(WORKER_USER_NAME_2))
				.isNull();
	}

	private Worker newWorker1() {
		return Worker.newInstance(WORKER_USER_NAME_1);
	}

	private Worker newWorker2() {
		return Worker.newInstance(WORKER_USER_NAME_2);
	}
}
