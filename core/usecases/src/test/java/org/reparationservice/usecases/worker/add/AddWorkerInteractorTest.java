package org.reparationservice.usecases.worker.add;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.reparationservice.doubles.WorkerGatewaySpy;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public class AddWorkerInteractorTest {
  private static final String WORKER_USERNAME = "username";
  private UseCaseActivator addWorker;
  private WorkerGatewaySpy workersSpy;
  private AddWorkerResponder responder = new AddWorkerResponderSpy();
  private UseCaseRequest request;

  @Before
  public void givenAddWorkerInteractor() {
    workersSpy = new WorkerGatewaySpy();
    request = new AddWorkerRequest(WORKER_USERNAME, responder);
    addWorker = new AddWorkerInteractor(workersSpy);
  }

  @Test
  public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
    assertThat(workersSpy.addWorkerWasCalled()).isFalse();
  }

  @Test
  public void executeAddOperation() {
    addWorker.execute(request);
    assertThat(workersSpy.addWorkerWasCalled()).isTrue();
    Worker worker = workersSpy.getWorker();
    assertThat(worker.getUserName()).isEqualTo(WORKER_USERNAME);
  }

  @Test
  public void throwWorkerAlreadyExistsWhenTwoWorkersWithSameUserNameAdded() {
    addWorker.execute(request);
    addWorker.execute(request);
    assertThat(((AddWorkerResponderSpy) responder).workerAlreadyExistsWasCalled()).isTrue();
    assertThat(workersSpy.addWorkerCalledTimes()).isEqualTo(1);
  }
}
