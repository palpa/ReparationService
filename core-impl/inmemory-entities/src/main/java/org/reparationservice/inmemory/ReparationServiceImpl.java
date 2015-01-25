package org.reparationservice.inmemory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.reparationservice.entities.ReparationService;
import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.worker.Worker;
import org.reparationservice.entities.worker.WorkerDTO;

public class ReparationServiceImpl implements
		ReparationService {
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
