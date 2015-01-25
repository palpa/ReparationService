package org.reparationservice.usecases.worker.add;

import org.reparationservice.requestor.UseCaseRequest;

public interface AddWorkerRequestBuilder {
  UseCaseRequest buildAddWorkerRequest(String username);
}
