package org.reparationservice.requestor;

import reparationservice.usecases.worker.add.AddWorkerInteractorFactory;
import reparationservice.usecases.worker.getall.GetAllWorkersInteractorFactory;

public interface InteractorFactory extends AddWorkerInteractorFactory,
    GetAllWorkersInteractorFactory {}
