package org.reparationservice.datanucleus.entities.worker;

import org.junit.Before;
import org.junit.Test;
import org.reparationservice.datanucleus.DatanucleusConfigurator;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class WorkerGatewayTest {
	private static final String WORKER_USER_NAME_1 = "UserName1";
	private static final String WORKER_USER_NAME_2 = "UserName2";
	private WorkerGateway workers;

	@Before
	public void setUp() {
		workers = DatanucleusConfigurator.instance.getWorkerGateway();
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
		assertThat(workerList).isNotNull();
		assertThat(workerList).isEmpty();
	  
	  workers.addWorker(newWorkerDTO(WORKER_USER_NAME_1));
	  workerList = workers.getAllWorkers();
		assertThat(workerList).isNotEmpty();
		assertThat(workerList.size()).isEqualTo(1);
		assertThat(workerList.iterator().next().getUserName()).isEqualTo(WORKER_USER_NAME_1);
	}

	private WorkerDTO newWorkerDTO(String userName) {
		return new WorkerDTO(userName);
	}
}
