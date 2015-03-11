package org.reparationservice.usecases.reparation.add;

import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.customer.Device;
import org.reparationservice.entities.customer.ReparationDTO;
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
		if (customer == Customer.NULL)
			throw new CustomerNotFound();

		Device device = customer.getDevice(repReq.getDeviceSerialNumber());

		if (device == Device.NULL)
			throw new DeviceNotFound();

		ReparationDTO reparationDTO = new ReparationDTO(
				repReq.getCreationDate(), repReq.getDeviceFailure());
		device.addReparation(reparationDTO);
	}

	public class CustomerNotFound extends RuntimeException {
		private static final long serialVersionUID = -4809605819126335670L;
	}

	public class DeviceNotFound extends RuntimeException {
		private static final long serialVersionUID = 5345290062168301775L;
	}
}
