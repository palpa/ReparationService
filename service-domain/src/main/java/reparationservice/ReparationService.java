package reparationservice;

import java.util.HashMap;
import java.util.Map;

import reparationservice.dtos.WorkerDTO;
import reparationservice.entities.Customer;
import reparationservice.entities.DeviceType;
import reparationservice.entities.Worker;
import reparationservice.gateways.CustomerGateway;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.gateways.WorkerGateway;

public class ReparationService implements WorkerGateway, DeviceTypeGateway,
		CustomerGateway {
	private Map<String, Worker> workers = new HashMap<String, Worker>();
	private Map<String, DeviceType> deviceTypes = new HashMap<String, DeviceType>();
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();

	@Override
	public void addWorker(WorkerDTO workerDTO) {
		Worker worker = Configurator.getNewWorker(workerDTO);
		workers.put(workerDTO.getUserName(), worker);
	}

	@Override
	public Worker getWorkerByUserName(String workerUserName) {
		if (workers.containsKey(workerUserName))
			return workers.get(workerUserName);
		return Worker.NULL;
	}

	@Override
	public void addDeviceType(String deviceTypeDescription) {
		this.deviceTypes.put(deviceTypeDescription,
				Configurator.getNewDeviceType(deviceTypeDescription));
	}

	@Override
	public DeviceType getDeviceTypeBy(String deviceTypeDescription) {
		if (deviceTypes.containsKey(deviceTypeDescription))
			return deviceTypes.get(deviceTypeDescription);
		return DeviceType.NULL;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		if (customers.containsKey(customerId))
			return customers.get(customerId);
		return Customer.NULL;
	}

	@Override
	public void addCustomer(long customerId) {
		customers.put(customerId, Configurator.getNewCustomer(customerId));
	}
}
