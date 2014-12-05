package reparationservice.requestor;

import reparationservice.usecases.worker.AddWorkerInteractorFactory;
import reparationservice.usecases.worker.GetAllWorkersInteractorFactory;

public interface InteractorFactory extends AddWorkerInteractorFactory,
    GetAllWorkersInteractorFactory {}
