package org.reparationservice.inmemory;

import org.reparationservice.inmemory.entities.devicetype.DeviceTypeImpl;
import org.reparationservice.inmemory.entities.ReparationService;
import org.reparationservice.inmemory.entities.worker.WorkerImpl;
import org.reparationservice.inmemory.entities.customer.CustomerImpl;
import org.reparationservice.inmemory.entities.customer.DeviceImpl;
import org.reparationservice.inmemory.entities.customer.ReparationImpl;
import reparationservice.entities.customer.Customer;
import reparationservice.entities.customer.CustomerGateway;
import reparationservice.entities.customer.Device;
import reparationservice.entities.customer.Reparation;
import reparationservice.entities.customer.ReparationDTO;
import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGateway;
import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;
import reparationservice.entities.worker.WorkerGateway;

public final class InMemoryConfigurator {
	private InMemoryConfigurator() {
		throw new AssertionError();
	}

	public static CustomerGateway getCustomerGateway() {
		return new ReparationService();
	}

	public static DeviceTypeGateway getDeviceTypeGateway() {
		return new ReparationService();
	}

	public static WorkerGateway getWorkerGateway() {
		return new ReparationService();
	}

	public static Customer getNewCustomer(long customerId) {
		return new CustomerImpl(customerId);
	}

	public static Device getNewDevice(long deviceSerialNumber) {
		return new DeviceImpl(deviceSerialNumber);
	}

	public static DeviceType getNewDeviceType(String deviceTypeDescription) {
		return new DeviceTypeImpl(deviceTypeDescription);
	}

	public static Reparation getNewReparation(ReparationDTO reparationDTO) {
		return new ReparationImpl(reparationDTO);
	}

	public static Worker getNewWorker(WorkerDTO workerDTO) {
		return new WorkerImpl(workerDTO);
	}
}
