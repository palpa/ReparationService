package reparationservice;

import java.util.ArrayList;
import java.util.List;

import reparationservice.entities.DeviceType;
import reparationservice.entities.Worker;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.gateways.WorkerGateway;

public class ReparationService implements WorkerGateway, DeviceTypeGateway {
	private List<Worker> workers = new ArrayList<Worker>();
	private List<DeviceType> deviceTypes = new ArrayList<DeviceType>();

	@Override
	public void addWorker(Worker worker) {
		if (workers.contains(worker))
			throw new WorkerAlreadyExists();
		workers.add(worker);
	}

	@Override
	public Worker getWorkerByUserName(String workerUserName) {
		for (Worker worker : workers) {
			if (worker.getUserName().equals(workerUserName))
				return worker;
		}
		return null;
	}

	@Override
	public DeviceType getDeviceType(String deviceTypeDescription) {
		for (DeviceType deviceType : deviceTypes) {
			if (deviceType.getDescription().equals(deviceTypeDescription))
				return deviceType;
		}
		return null;
	}

	@Override
	public void addDeviceType(DeviceType deviceType) {
		if (deviceTypes.contains(deviceType))
			throw new DeviceTypeAlreadyExists();
		this.deviceTypes.add(deviceType);
	}
}
