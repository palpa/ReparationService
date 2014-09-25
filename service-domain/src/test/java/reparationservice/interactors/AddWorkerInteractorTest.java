package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;

public class AddWorkerInteractorTest {

	private static final String WORKER_USERNAME = "username";
	private Interactor addWorker;
	private WorkerGateway workerGateway;

	@Before
	public void givenAddWorkerInteractor() {
		workerGateway = new ReparationService();
		addWorker = new AddWorkerInteractor(WORKER_USERNAME, workerGateway);
	}

	@Test
	public void executeAddOperation() {
		addWorker.execute();	
		Worker worker = workerGateway.getWorkerByUserName(WORKER_USERNAME);
		assertThat(worker.getUserName()).isEqualTo(WORKER_USERNAME);
	}
	
	@Test(expected = AddWorkerInteractor.WorkerAlreadyExists.class)
	public void throwWorkerAlreadyExistsWhenTwoWorkersWithSameUserNameAdded() {
		addWorker.execute();
		addWorker.execute();
	}

}
