package reparationservice.interactors;

import reparationservice.entities.DeviceType;
import reparationservice.gateways.DeviceTypeGateway;

public class AddDeviceTypeInteractor implements Interactor {
	private String deviceTypeDescription;
	private DeviceTypeGateway deviceTypes;

	public AddDeviceTypeInteractor(String deviceTypeDescription, DeviceTypeGateway deviceTypes) {
		this.deviceTypeDescription = deviceTypeDescription;
		this.deviceTypes = deviceTypes;
	}

	@Override
	public void execute() {
		if (deviceTypes.getDeviceType(deviceTypeDescription) != null)
			throw new DeviceTypeAlreadyExists();
		deviceTypes.addDeviceType(DeviceType.newInstance(deviceTypeDescription));
	}
	
	public class DeviceTypeAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 1944478993212099527L;
	}
}
