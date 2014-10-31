package org.reparationservice.rest.controllers;

import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reparationservice.gateways.WorkerGateway;
import reparationservice.interactors.AddWorkerInteractor;
import reparationservice.requests.AddWorkerRequest;
import reparationservice.requests.Request;

@RestController
public class AddWorkerController {
  private WorkerGateway workerGW;
  
  @Autowired
  public AddWorkerController(WorkerGateway workerGW) {
    this.workerGW = workerGW;
  }

  @RequestMapping(value = "/workers", method = RequestMethod.POST)
  ResponseEntity<?> addWorker(@RequestBody AddWorkerJsonRequest workerReq) {
    AddWorkerInteractor interactor = new AddWorkerInteractor(workerGW);
    Request request = new AddWorkerRequest(workerReq.getUsername());
    interactor.execute(request);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
