package org.reparationservice.usecases.worker.getall;

import static org.assertj.core.api.Assertions.assertThat;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.reparationservice.doubles.GetAllWorkersGatewaySpy;
import org.reparationservice.doubles.GetAllWorkersResponderSpy;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;

@RunWith(HierarchicalContextRunner.class)
public class GetAllWorkersInteractorTest {

  @Test(expected = GetAllWorkerInteractor.WorkerGatewayCannotBeNull.class)
  public void throwExceptionWhenNullGatewayPassed() {
    new GetAllWorkerInteractor(null);
  }

  public class InteractorCreated {
    private WorkerGateway workerGateway;
    private UseCaseActivator getAllWorkers;

    @Before
    public void givenInteractor() {
      workerGateway = new GetAllWorkersGatewaySpy();
      getAllWorkers = new GetAllWorkerInteractor(workerGateway);
    }

    @Test(expected = GetAllWorkerInteractor.GetAllWorkersRequestCannotBeNull.class)
    public void throwExceptionWhenNullRequestReceived() {
      getAllWorkers.execute(null);
    }

    @Test
    public void returnsAllWorkersWhenExecuteIsCalled() {
      GetAllWorkersResponder responder = new GetAllWorkersResponderSpy();
      GetAllWorkersRequest request = new GetAllWorkersRequest(responder);

      getAllWorkers.execute(request);

      GetAllWorkersGatewaySpy workerGatewaySpy = (GetAllWorkersGatewaySpy) workerGateway;
      assertThat(workerGatewaySpy.getAllWorkersWasCalled()).isTrue();

      GetAllWorkersResponderSpy respSpy = (GetAllWorkersResponderSpy) responder;
      assertThat(respSpy.bindModelWasCalled()).isTrue();
      assertThat(GetAllWorkersGatewaySpy.workerListSize)
          .isEqualTo(respSpy.getWorkerCollection().size());
    }
  }
}
