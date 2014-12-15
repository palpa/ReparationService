package reparationservice.usecases.worker.getall;

import static org.junit.Assert.*;

import org.junit.Test;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.entities.worker.GetAllWorkersGatewaySpy;
import reparationservice.requestor.UseCaseActivator;

public class GetAllWorkersInteractorTest {
  
  @Test(expected = GetAllWorkerInteractor.WorkerGatewayNotNull.class)
  public void throwExceptionWhenNullGatewayPassed() {
    new GetAllWorkerInteractor(null, new GetAllWorkersResponderSpy());
  }
  
  @Test(expected = GetAllWorkerInteractor.PresenterNotNull.class)
  public void throwExceptionWhenNullPresenterPassed() {
    new GetAllWorkerInteractor(new GetAllWorkersGatewaySpy(), null);
  }
  
  @Test
  public void returnsAllWorkersWhenExecuteIsCalled() {
    GetAllWorkersResponder allWorkersPresenter = new GetAllWorkersResponderSpy();
    WorkerGateway workerGateway = new GetAllWorkersGatewaySpy();
    
    UseCaseActivator getAllWorkers = new GetAllWorkerInteractor(workerGateway, allWorkersPresenter);
    getAllWorkers.execute();

    GetAllWorkersGatewaySpy workerGatewaySpy = (GetAllWorkersGatewaySpy) workerGateway;
    assertTrue(workerGatewaySpy.getAllWorkersWasCalled());
    assertTrue(((GetAllWorkersResponderSpy) allWorkersPresenter).bindModelWasCalled());
  }
}