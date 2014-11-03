package reparationservice.interactors;

import reparationservice.entities.DeviceType;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.interactors.requests.AddDeviceTypeRequest;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public class AddDeviceTypeInteractor implements UseCaseActivator {
	private DeviceTypeGateway deviceTypes;

	public AddDeviceTypeInteractor(DeviceTypeGateway deviceTypes) {
		this.deviceTypes = deviceTypes;
	}

	@Override
	public void execute(UseCaseRequest request) {
		AddDeviceTypeRequest dtReq = (AddDeviceTypeRequest) request;
		String deviceTypeDescription = dtReq.getDescription();
		
		if (deviceTypes.getDeviceTypeBy(deviceTypeDescription) != DeviceType.NULL)
			throw new DeviceTypeAlreadyExists();

		deviceTypes.addDeviceType(deviceTypeDescription);
	}

	public class DeviceTypeAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 1944478993212099527L;
	}
}
