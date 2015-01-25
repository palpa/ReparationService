package org.reparationservice.requestor;

import org.reparationservice.usecases.worker.add.AddWorkerInteractorFactory;
import org.reparationservice.usecases.worker.getall.GetAllWorkersInteractorFactory;

public interface InteractorFactory extends AddWorkerInteractorFactory,
        GetAllWorkersInteractorFactory {}
