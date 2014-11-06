package reparationservice.usecases.worker;

import reparationservice.requestor.UseCaseRequest;

public interface AddWorkerRequestBuilder {
  UseCaseRequest buildAddWorkerRequest(String username);
}
