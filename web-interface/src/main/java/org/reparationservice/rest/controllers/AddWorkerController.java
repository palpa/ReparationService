package org.reparationservice.rest.controllers;

import org.reparationservice.rest.requestor.InteractorFactory;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reparationservice.interactors.AddWorkerInteractor.WorkerAlreadyExists;
import reparationservice.interactors.Interactor;
import reparationservice.requests.AddWorkerRequest;
import reparationservice.requests.Request;

@RestController
public class AddWorkerController {
  private final InteractorFactory intFactory;

  @Autowired
  public AddWorkerController(InteractorFactory intFactory) {
    this.intFactory = intFactory;
  }

  @RequestMapping(value = "/workers", method = RequestMethod.POST)
  ResponseEntity<?> addWorker(@RequestBody AddWorkerJsonRequest workerReq) {
    Interactor interactor = intFactory.make("AddWorkerInteractor");
    Request request = new AddWorkerRequest(workerReq.getUsername());
    interactor.execute(request);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }


  @ControllerAdvice
  public static class AddWorkerControllerAdvice {
    @ResponseBody
    @ExceptionHandler(WorkerAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    VndErrors workerAlreadyExistsExceptionHandler(WorkerAlreadyExists ex) {
      String message = (ex.getMessage() == null || ex.getMessage().isEmpty()) ?
          "Worker Already Exists" : ex.getMessage();
      return new VndErrors("error", message);
    }
  }
}
