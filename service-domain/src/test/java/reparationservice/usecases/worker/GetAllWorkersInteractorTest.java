package reparationservice.usecases.worker;

import static org.junit.Assert.*;

import org.junit.Test;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.entities.worker.GetAllWorkersGatewaySpy;
import reparationservice.requestor.UseCaseActivator;

public class GetAllWorkersInteractorTest {
  @Test
  public void returnsAllWorkersWhenExecuteIsCalled() {
    GetAllWorkersResponder allWorkersPresenter = new GetAllWorkersResponderSpy();
    
    WorkerGateway workerGateway = new GetAllWorkersGatewaySpy();
    UseCaseActivator getAllWorkers = new GetAllWorkerInteractor(workerGateway, allWorkersPresenter);
    getAllWorkers.execute(null);

    GetAllWorkersGatewaySpy workerGatewaySpy = (GetAllWorkersGatewaySpy) workerGateway;
    assertTrue(workerGatewaySpy.getAllWorkersWasCalled());
    assertTrue(((GetAllWorkersResponderSpy) allWorkersPresenter).bindModelWasCalled());
    assertNotNull(allWorkersPresenter.getModel());
  }
}
