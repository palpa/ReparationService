package reparationservice.entities.worker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;
import reparationservice.persistenceimpls.inmemory.InMemoryConfigurator;
import de.bechte.junit.runners.context.HierarchicalContextRunner;

@RunWith(HierarchicalContextRunner.class)
public class WorkerTests {
	private static final String USER_NAME = "UserName";
	private static final String EMPTY_USERNAME = "";
	
	@Test
	public void workerSpecialCase() {
		Worker worker = Worker.NULL;
		assertThat(worker).isNotNull();
		assertThat(worker.getUserName()).isEqualTo(EMPTY_USERNAME);
	}

	public class InMemoryImpl {	
		private WorkerDTO workerDTO;
		
		@Before
		public void setUp() {
			workerDTO = new WorkerDTO(USER_NAME);
		}

		@Test
		public void testWorkerDTO() {
			assertThat(workerDTO).isNotNull();
			assertThat(workerDTO.getUserName()).isEqualTo(USER_NAME);
		}

		@Test
		public void createWorker() {
			Worker worker = InMemoryConfigurator.getNewWorker(workerDTO);
			assertThat(worker).isNotNull();
			assertThat(worker.getUserName()).isEqualTo(USER_NAME);
		}
	}
}
