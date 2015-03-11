package org.reparationservice.usecases.customer.add;

import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public final class AddCustomerInteractor implements UseCaseActivator {
  private final CustomerGateway customers;

  public AddCustomerInteractor(CustomerGateway customers) {
    if (customers == null)
      throw new CustomerGatewayCannotBeNull();
    this.customers = customers;
  }

  @Override
  public void execute(UseCaseRequest request) {
    if (request == null)
      throw new RequestCannotBeNull();

    long customerId = ((AddCustomerRequest) request).getId();
    customers.addCustomer(customerId);
  }

  class RequestCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = -8424684392205119848L;
  }

  class CustomerGatewayCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = 6821771280959420623L;
  }
}
