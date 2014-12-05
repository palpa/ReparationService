package org.reparationservice.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.usecases.worker.GetAllWorkersInteractorFactory;
import reparationservice.usecases.worker.GetAllWorkersResponder;

@Controller
@RequestMapping(value = "/workers", produces = "application/hal+json")
public final class GetAllWorkersController implements GetAllWorkersResponder {
  private final WorkerGateway workers;
  private final GetAllWorkersInteractorFactory intFactory;
  private List<Worker> workerList;

  @Autowired
  public GetAllWorkersController(GetAllWorkersInteractorFactory intFactory
      , WorkerGateway workers) {
    this.workers = workers;
    this.intFactory = intFactory;
  }

  @RequestMapping(method = RequestMethod.GET)
  ResponseEntity<Resources<Worker>> getWorkers() {
    UseCaseActivator interactor = intFactory.makeGetAllWorkersInteractor(workers, this);
    interactor.execute();
    Resources<Worker> res = new Resources<>(this.workerList);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @Override
  public void bindModel(Iterable<Worker> workerList) {
    this.workerList = new ArrayList<Worker>();
    
    for (Worker worker : workerList) {
      this.workerList.add(worker);
    }
  }
}
