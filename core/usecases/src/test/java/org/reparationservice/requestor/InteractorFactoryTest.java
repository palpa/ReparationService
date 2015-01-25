package org.reparationservice.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.entities.worker.WorkerGatewaySpy;
import org.reparationservice.requestor.impl.InteractorFactoryImpl;
import reparationservice.usecases.worker.add.AddWorkerInteractor;
import reparationservice.usecases.worker.getall.GetAllWorkerInteractor;
import reparationservice.usecases.worker.getall.GetAllWorkersResponderSpy;

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
    UseCaseActivator addWorkerInteractor = intFactory
        .makeAddWorkerInteractor(workerGateway, null);
    assertThat(addWorkerInteractor).isInstanceOf(AddWorkerInteractor.class);
  }

  @Test
  public void makeGetAllWorkersInteractor() {
    UseCaseActivator interactor = intFactory.makeGetAllWorkersInteractor(workerGateway,
        new GetAllWorkersResponderSpy());
    assertThat(interactor).isInstanceOf(GetAllWorkerInteractor.class);
  }
}
