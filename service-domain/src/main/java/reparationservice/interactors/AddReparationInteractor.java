package reparationservice.interactors;

import reparationservice.dtos.ReparationDTO;
import reparationservice.entities.Customer;
import reparationservice.entities.Device;
import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddReparationRequest;
import reparationservice.requests.Request;

public class AddReparationInteractor implements Interactor {
	private CustomerGateway customers;

	public AddReparationInteractor(CustomerGateway customers) {
		this.customers = customers;
	}

	@Override
	public void execute(Request request) {
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
