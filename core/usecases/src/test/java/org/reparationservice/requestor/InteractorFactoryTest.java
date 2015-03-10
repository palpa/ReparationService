package org.reparationservice.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.reparationservice.doubles.WorkerGatewaySpy;
import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.impl.InteractorFactoryImpl;
import org.reparationservice.usecases.worker.add.AddWorkerInteractor;
import org.reparationservice.usecases.worker.getall.GetAllWorkerInteractor;

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
        .makeAddWorkerInteractor(workerGateway);
    assertThat(addWorkerInteractor).isInstanceOf(AddWorkerInteractor.class);
  }

  @Test
  public void makeGetAllWorkersInteractor() {
    UseCaseActivator interactor = intFactory.makeGetAllWorkersInteractor(workerGateway);
    assertThat(interactor).isInstanceOf(GetAllWorkerInteractor.class);
  }
}
