package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Worker;
import reparationservice.gateways.WorkerGateway;
import reparationservice.requests.AddWorkerRequest;
import reparationservice.requests.Request;

public class AddWorkerInteractorTest {
	private static final String WORKER_USERNAME = "username";
	private Interactor addWorker;
	private WorkerGateway workerGateway;
	private Request request;

	@Before
	public void givenAddWorkerInteractor() {
		workerGateway = new ReparationService();
		addWorker = new AddWorkerInteractor(workerGateway);
		request = new AddWorkerRequest(WORKER_USERNAME);
	}

	@Test
	public void executeAddOperation() {
		addWorker.execute(request);
		Worker worker = workerGateway.getWorkerByUserName(WORKER_USERNAME);
		assertThat(worker.getUserName()).isEqualTo(WORKER_USERNAME);
	}

	@Test(expected = AddWorkerInteractor.WorkerAlreadyExists.class)
	public void throwWorkerAlreadyExistsWhenTwoWorkersWithSameUserNameAdded() {
		addWorker.execute(request);
		addWorker.execute(request);
	}
}
