package reparationservice.usecases.worker.add;

import reparationservice.requestor.UseCaseRequest;

public interface AddWorkerRequestBuilder {
  UseCaseRequest buildAddWorkerRequest(String username);
}
