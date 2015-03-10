package org.reparationservice.rest.controllers;

import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;
import org.reparationservice.rest.requests.AddWorkerJsonRequest;
import org.reparationservice.usecases.worker.add.AddWorkerInteractorFactory;
import org.reparationservice.usecases.worker.add.AddWorkerRequestBuilder;
import org.reparationservice.usecases.worker.add.AddWorkerResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    AddWorkerResponder responder = new AddWorkerPresenter();
    UseCaseRequest request = requestBuilder
        .buildAddWorkerRequest(workerReq.getUsername(), responder);

    UseCaseActivator interactor = intFactory.makeAddWorkerInteractor(workers, request);
    interactor.execute();

    return ((AddWorkerPresenter) responder).getResponse();
  }

  private class AddWorkerPresenter implements AddWorkerResponder {

    private ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.CREATED);

    @Override public void workerAlreadyExists() {
      response = new ResponseEntity<>(new VndErrors("error", "Worker Already Exists"),
          HttpStatus.CONFLICT);
    }

    public ResponseEntity<?> getResponse() {
      return response;
    }
  }
}
