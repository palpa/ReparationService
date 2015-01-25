package org.reparationservice.rest.controllers;

import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.reparationservice.usecases.worker.add.AddWorkerInteractor;
import org.reparationservice.usecases.worker.add.AddWorkerInteractorFactory;
import org.reparationservice.usecases.worker.add.AddWorkerRequestBuilder;
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

@RestController
public class AddWorkerController {
  private final AddWorkerInteractorFactory intFactory;
  private WorkerGateway workers;
  private final AddWorkerRequestBuilder requestBuilder;

  @Autowired
  public AddWorkerController(AddWorkerInteractorFactory intFactory,
      WorkerGateway workers,
      AddWorkerRequestBuilder requestBuilder) {
    this.workers = workers;
    this.intFactory = intFactory;
    this.requestBuilder = requestBuilder;
  }

  @RequestMapping(value = "/workers", method = RequestMethod.POST)
  ResponseEntity<?> addWorker(@RequestBody AddWorkerJsonRequest workerReq) {
    UseCaseRequest request = requestBuilder
        .buildAddWorkerRequest(workerReq.getUsername());
    UseCaseActivator interactor = intFactory.makeAddWorkerInteractor(workers, request);
    interactor.execute();
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @ControllerAdvice
  public static class AddWorkerControllerAdvice {
    @ResponseBody
    @ExceptionHandler(AddWorkerInteractor.WorkerAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    VndErrors workerAlreadyExistsExceptionHandler(AddWorkerInteractor.WorkerAlreadyExists ex) {
      String message = (ex.getMessage() == null || ex.getMessage().isEmpty()) ?
          "Worker Already Exists" : ex.getMessage();
      return new VndErrors("error", message);
    }
  }
}
