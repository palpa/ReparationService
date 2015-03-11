package org.reparationservice.rest.controllers;

import java.util.Collection;
import java.util.Collections;

import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;
import org.reparationservice.usecases.worker.getall.GetAllWorkersRequestBuilder;
import org.reparationservice.usecases.worker.getall.GetAllWorkersResponder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/workers", produces = "application/hal+json")
public final class GetAllWorkersController implements GetAllWorkersResponder {
  private final UseCaseActivator interactor;
  private final GetAllWorkersRequestBuilder requestBuilder;

  private Iterable<WorkerDTO> workerList = Collections.emptyList();

  @Autowired
  public GetAllWorkersController(@Qualifier("GetAllWorkersInteractor") UseCaseActivator interactor,
      GetAllWorkersRequestBuilder requestBuilder) {
    this.interactor = interactor;
    this.requestBuilder = requestBuilder;
  }

  @RequestMapping(method = RequestMethod.GET) ResponseEntity<Resources<WorkerDTO>> getWorkers() {
    UseCaseRequest request = requestBuilder.buildGetAllWorkersRequest(this);
    interactor.execute(request);
    Resources<WorkerDTO> res = new Resources<>(this.workerList);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

  @Override
  public void bindModel(Collection<WorkerDTO> workerList) {
    this.workerList = workerList;
  }
}
