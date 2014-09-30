package reparationservice;

import java.util.HashMap;
import java.util.Map;

import reparationservice.entities.Customer;
import reparationservice.entities.DeviceType;
import reparationservice.entities.Worker;
import reparationservice.gateways.CustomerGateway;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.gateways.WorkerGateway;

public class ReparationService implements WorkerGateway, DeviceTypeGateway, CustomerGateway {
	private Map<String, Worker> workers = new HashMap<String, Worker>();
	private Map<String, DeviceType> deviceTypes = new HashMap<String, DeviceType>();

	@Override
	public void addWorker(Worker worker) {
		workers.put(worker.getUserName(), worker);
	}

	@Override
	public Worker getWorkerByUserName(String workerUserName) {
		if (workers.containsKey(workerUserName))
			return workers.get(workerUserName);
		return Worker.NULL;
	}

	@Override
	public void addDeviceType(DeviceType deviceType) {
		this.deviceTypes.put(deviceType.getDescription(), deviceType);
	}
	
	@Override
	public DeviceType getDeviceTypeBy(String deviceTypeDescription) {
		if (deviceTypes.containsKey(deviceTypeDescription))
			return deviceTypes.get(deviceTypeDescription);
		return DeviceType.NULL;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
