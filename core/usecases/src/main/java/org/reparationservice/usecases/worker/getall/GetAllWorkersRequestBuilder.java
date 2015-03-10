package org.reparationservice.usecases.worker.getall;

import org.reparationservice.requestor.UseCaseRequest;

public interface GetAllWorkersRequestBuilder {
  UseCaseRequest buildGetAllWorkersRequest(GetAllWorkersResponder responder);
}
