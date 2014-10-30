package org.reparationservice.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reparationservice.gateways.WorkerGateway;
import reparationservice.interactors.AddWorkerInteractor;
import reparationservice.requests.AddWorkerRequest;
import reparationservice.requests.Request;

@RestController
public class AddWorkerController {
  @Autowired
  public AddWorkerController(WorkerGateway workerGW) {
    this.workerGW = workerGW;
  }

  private WorkerGateway workerGW;

  @RequestMapping(value = "/workers", method = RequestMethod.POST)
  ResponseEntity<?> addWorker() {
    AddWorkerInteractor interactor = new AddWorkerInteractor(workerGW);

    Request request = new AddWorkerRequest("username");
    interactor.execute(request);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
