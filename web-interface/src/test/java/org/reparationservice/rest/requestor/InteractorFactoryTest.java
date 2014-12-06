package org.reparationservice.rest.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.entities.worker.WorkerGatewaySpy;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerInteractor;
import reparationservice.usecases.worker.GetAllWorkerInteractor;
import reparationservice.usecases.worker.GetAllWorkersResponderSpy;

public class InteractorFactoryTest {
  private WorkerGateway workerGateway;
  private InteractorFactory intFactory;

  @Before
  public void setUp() {
    workerGateway = new WorkerGatewaySpy();
    intFactory = new InteractorFactoryImpl();
  }

  @Test
  public void makeAddWorkerInteractor() {   
    UseCaseRequest request = null;
    UseCaseActivator addWorkerInteractor = intFactory
        .makeAddWorkerInteractor(workerGateway, request);
    assertThat(addWorkerInteractor).isInstanceOf(AddWorkerInteractor.class);
  }

  @Test
  public void makeGetAllWorkersInteractor() {
    UseCaseActivator interactor = intFactory.makeGetAllWorkersInteractor(workerGateway,
        new GetAllWorkersResponderSpy());
    assertThat(interactor).isInstanceOf(GetAllWorkerInteractor.class);
  }
}
