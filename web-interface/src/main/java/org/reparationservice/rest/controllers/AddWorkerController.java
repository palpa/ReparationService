package org.reparationservice.rest.controllers;

import java.util.HashMap;

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

import reparationservice.entities.worker.WorkerGateway;
import reparationservice.requestor.InteractorFactory;
import reparationservice.requestor.RequestBuilder;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.worker.AddWorkerInteractor.WorkerAlreadyExists;

@RestController
public class AddWorkerController {
  private final InteractorFactory intFactory;
  private WorkerGateway workers;
  private final RequestBuilder requestBuilder;

  @Autowired
  public AddWorkerController(InteractorFactory intFactory, WorkerGateway workers,
      RequestBuilder requestBuilder) {
    this.workers = workers;
    this.intFactory = intFactory;
    this.requestBuilder = requestBuilder;
  }

  @RequestMapping(value = "/workers", method = RequestMethod.POST)
  ResponseEntity<?> addWorker(@RequestBody AddWorkerJsonRequest workerReq) {
    HashMap<String, Object> args = new HashMap<String, Object>();
    args.put("username", workerReq.getUsername());
    UseCaseRequest request = requestBuilder.build("AddWorkerRequest", args);

    UseCaseActivator interactor = intFactory.makeAddWorkerInteractor(workers);
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
