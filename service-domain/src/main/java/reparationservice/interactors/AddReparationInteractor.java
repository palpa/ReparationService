package reparationservice.interactors;

import org.joda.time.DateTime;

import reparationservice.gateways.CustomerGateway;

public class AddReparationInteractor implements Interactor {
	public AddReparationInteractor(DateTime creationDate, String failure,
			String urgency, String observations, long customerId,
			long deviceSerialNumber, CustomerGateway customers) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		throw new CustomerNotFound();

	}
	
	public class CustomerNotFound extends RuntimeException {
		private static final long serialVersionUID = -4809605819126335670L;
	}
}
