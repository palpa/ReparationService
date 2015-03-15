package org.reparationservice.inmemory;

import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.entities.worker.WorkerGateway;

public final class InMemoryConfigurator {
	private InMemoryConfigurator() {
		throw new AssertionError();
	}

	public static CustomerGateway getCustomerGateway() {
		return new ReparationServiceImpl();
	}

	public static DeviceTypeGateway getDeviceTypeGateway() {
		return new ReparationServiceImpl();
	}

	public static WorkerGateway getWorkerGateway() {
		return new ReparationServiceImpl();
	}

}
