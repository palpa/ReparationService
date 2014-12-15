package reparationservice.entities.worker;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;

public class WorkerGatewayTest {
	private static final String WORKER_USER_NAME_1 = "UserName1";
	private static final String WORKER_USER_NAME_2 = "UserName2";
	private WorkerGateway workers;

	@Before
	public void setUp() {
		workers = InMemoryConfigurator.getWorkerGateway();
	}

	@Test
	public void returnNullWorkerWhenWorkerNotFound() {
		assertThat(workers.getWorkerByUserName(WORKER_USER_NAME_1))
				.isEqualTo(Worker.NULL);
	}
	
	@Test
	public void testAddWorker() {
		workers.addWorker(newWorkerDTO(WORKER_USER_NAME_1));
		workers.addWorker(newWorkerDTO(WORKER_USER_NAME_2));

		Worker worker1 = workers
				.getWorkerByUserName(WORKER_USER_NAME_1);
		assertThat(worker1.getUserName()).isEqualTo(WORKER_USER_NAME_1);

		Worker worker2 = workers
				.getWorkerByUserName(WORKER_USER_NAME_2);
		assertThat(worker2.getUserName()).isEqualTo(WORKER_USER_NAME_2);
	}
	
	@Test
  public void testGetAllWorkers() {
	  Collection<Worker> workerList = workers.getAllWorkers();
	  assertNotNull(workerList);
	  assertTrue(workerList.isEmpty());
	  
	  workers.addWorker(newWorkerDTO(WORKER_USER_NAME_1));
	  workerList = workers.getAllWorkers();
	  assertFalse(workerList.isEmpty());
	  assertEquals(1, workerList.size());
	  assertEquals(WORKER_USER_NAME_1, workerList.iterator().next().getUserName());
	}

	private WorkerDTO newWorkerDTO(String userName) {
		return new WorkerDTO(userName);
	}
}
