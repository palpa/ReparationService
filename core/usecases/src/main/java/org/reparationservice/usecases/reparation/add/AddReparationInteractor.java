package org.reparationservice.usecases.reparation.add;

import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.customer.Device;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public final class AddReparationInteractor implements UseCaseActivator {
  private final CustomerGateway customers;

  public AddReparationInteractor(CustomerGateway customers) {
    this.customers = customers;
  }

  @Override
  public void execute(UseCaseRequest request) {
    AddReparationRequest repReq = (AddReparationRequest) request;

    if (customerIsFound(repReq))
      if (deviceIsFound(repReq))
        addReparation(repReq);
      else
        repReq.deviceNotFound();
    else
      repReq.customerNotFound();
  }

  private void addReparation(AddReparationRequest repReq) {
    customers.getCustomerById(repReq.getCustomerId())
        .getDevice(repReq.getDeviceSerialNumber()).addReparation(repReq);
  }

  private boolean deviceIsFound(AddReparationRequest repReq) {
    return customers.getCustomerById(repReq.getCustomerId())
        .getDevice(repReq.getDeviceSerialNumber()) != Device.NULL;
  }

  private boolean customerIsFound(AddReparationRequest repReq) {
    return customers.getCustomerById(repReq.getCustomerId()) != Customer.NULL;
  }
}
