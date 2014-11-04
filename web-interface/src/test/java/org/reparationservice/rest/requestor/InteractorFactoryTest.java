package org.reparationservice.rest.requestor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.entities.worker.WorkerGatewaySpy;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.usecases.worker.AddWorkerInteractor;

public class InteractorFactoryTest {
  @Test
  public void makeAddWorkerInteractor() {
    WorkerGateway workerGateway = new WorkerGatewaySpy();
    InteractorFactory intFactory = new InteractorFactoryImpl();
    UseCaseActivator addWorkerInteractor = intFactory
        .makeAddWorkerInteractor(workerGateway);
    assertThat(addWorkerInteractor).isInstanceOf(AddWorkerInteractor.class);
    assertThat(((AddWorkerInteractor) addWorkerInteractor).getGateway()).isInstanceOf(
        workerGateway.getClass());
  }
}
