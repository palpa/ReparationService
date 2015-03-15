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

    Customer customer = customers.getCustomerById(repReq.getCustomerId());
    if (customerNotFound(customer))
      repReq.customerNotFound();
    else {
      Device device = customer.getDevice(repReq.getDeviceSerialNumber());
      if (deviceNotFound(device))
        repReq.deviceNotFound();
      else
        device.addReparation(repReq);
    }
  }

  private boolean deviceNotFound(Device device) {
    return device == Device.NULL;
  }

  private boolean customerNotFound(Customer customer) {
    return customer == Customer.NULL;
  }
}
