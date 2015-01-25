package org.reparationservice.datanucleus;

import org.reparationservice.datanucleus.entities.devicetype.DeviceTypeImpl;
import org.reparationservice.datanucleus.entities.worker.WorkerImpl;
import org.reparationservice.datanucleus.entities.customer.CustomerImpl;
import org.reparationservice.datanucleus.entities.customer.DeviceImpl;
import org.reparationservice.datanucleus.entities.customer.ReparationImpl;
import org.reparationservice.entities.Configurator;
import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.customer.CustomerGateway;
import org.reparationservice.entities.customer.Device;
import org.reparationservice.entities.customer.Reparation;
import org.reparationservice.entities.customer.ReparationDTO;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;
import org.reparationservice.entities.worker.WorkerGateway;

public final class DatanucleusConfigurator implements Configurator {
	public static final Configurator instance = new DatanucleusConfigurator();

	@Override
	public CustomerGateway getCustomerGateway() {
		return new ReparationServiceImpl();
	}

	@Override
	public DeviceTypeGateway getDeviceTypeGateway() {
		return new ReparationServiceImpl();
	}

	@Override
	public WorkerGateway getWorkerGateway() {
		return new ReparationServiceImpl();
	}

	@Override
	public Customer getNewCustomer(long customerId) {
		return new CustomerImpl(customerId);
	}

	@Override
	public Device getNewDevice(long deviceSerialNumber) {
		return new DeviceImpl(deviceSerialNumber);
	}

	@Override
	public DeviceType getNewDeviceType(String deviceTypeDescription) {
		return new DeviceTypeImpl(deviceTypeDescription);
	}

	@Override
	public Reparation getNewReparation(ReparationDTO reparationDTO) {
		return new ReparationImpl(reparationDTO);
	}

	@Override
	public Worker getNewWorker(WorkerDTO workerDTO) {
		return new WorkerImpl(workerDTO);
	}
}
