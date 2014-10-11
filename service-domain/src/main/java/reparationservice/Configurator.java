package reparationservice;

import reparationservice.dtos.ReparationDTO;
import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Customer;
import reparationservice.entities.Device;
import reparationservice.entities.DeviceType;
import reparationservice.entities.Reparation;
import reparationservice.entities.Worker;
import reparationservice.entities.impl.CustomerImpl;
import reparationservice.entities.impl.DeviceImpl;
import reparationservice.entities.impl.DeviceTypeImpl;
import reparationservice.entities.impl.ReparationImpl;
import reparationservice.entities.impl.WorkerImpl;
import reparationservice.gateways.CustomerGateway;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.gateways.WorkerGateway;

public final class Configurator {
	private Configurator() {
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
