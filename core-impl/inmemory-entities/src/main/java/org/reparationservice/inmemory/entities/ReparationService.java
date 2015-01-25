package org.reparationservice.inmemory.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.reparationservice.inmemory.InMemoryConfigurator;
import reparationservice.entities.customer.Customer;
import reparationservice.entities.customer.CustomerGateway;
import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGateway;
import reparationservice.entities.worker.Worker;
import reparationservice.entities.worker.WorkerDTO;
import reparationservice.entities.worker.WorkerGateway;

public class ReparationService implements WorkerGateway, DeviceTypeGateway,
		CustomerGateway {
	private Map<String, Worker> workers = new HashMap<>();
	private Map<String, DeviceType> deviceTypes = new HashMap<>();
	private Map<Long, Customer> customers = new HashMap<>();

	@Override
	public void addWorker(WorkerDTO workerDTO) {
		Worker worker = InMemoryConfigurator.getNewWorker(workerDTO);
		workers.put(workerDTO.getUserName(), worker);
	}

  @Override
  public Collection<Worker> getAllWorkers() {
    return workers.values();
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
				InMemoryConfigurator.getNewDeviceType(deviceTypeDescription));
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
		customers.put(customerId, InMemoryConfigurator.getNewCustomer(customerId));
	}
}
