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

  @Before
  public void givenAddWorkerInteractor() {
    workersSpy = new WorkerGatewaySpy();
    UseCaseRequest request = new AddWorkerRequest(WORKER_USERNAME);
    addWorker = new AddWorkerInteractor(workersSpy, request);
  }

  @Test
  public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
    assertThat(workersSpy.addWorkerWasCalled()).isFalse();
  }

  @Test
  public void executeAddOperation() {
    addWorker.execute();
    assertThat(workersSpy.addWorkerWasCalled()).isTrue();
    Worker worker = workersSpy.getWorker();
    assertThat(worker.getUserName()).isEqualTo(WORKER_USERNAME);
  }

  @Test(expected = AddWorkerInteractor.WorkerAlreadyExists.class)
  public void throwWorkerAlreadyExistsWhenTwoWorkersWithSameUserNameAdded() {
    addWorker.execute();
    addWorker.execute();
  }
}
