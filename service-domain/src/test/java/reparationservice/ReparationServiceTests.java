package reparationservice;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.Worker;

public class ReparationServiceTests {
	private static final String WORKER_USER_NAME = "UserName";
	private ReparationService reparationService;

	@Before
	public void setUp() {
		reparationService = new ReparationService();
	}

	@Test
	public void addWorkerToReparationService() {
		Worker worker = newWorker();
		reparationService.add(worker);
		
		assertThat(reparationService.getWorker(worker)).isEqualTo(newWorker());
	}

	private Worker newWorker() {
		return Worker.newInstance(WORKER_USER_NAME);
	}
}
