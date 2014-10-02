package reparationservice.interactors;

import reparationservice.entities.DeviceType;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.requests.AddDeviceTypeRequest;
import reparationservice.requests.Request;

public class AddDeviceTypeInteractor implements Interactor {
	private DeviceTypeGateway deviceTypes;

	public AddDeviceTypeInteractor(DeviceTypeGateway deviceTypes) {
		this.deviceTypes = deviceTypes;
	}

	@Override
	public void execute(Request request) {
		AddDeviceTypeRequest dtReq = (AddDeviceTypeRequest) request;
		String deviceTypeDescription = dtReq.getDescription();
		
		if (deviceTypes.getDeviceTypeBy(deviceTypeDescription) != DeviceType.NULL)
			throw new DeviceTypeAlreadyExists();

		deviceTypes.addDeviceType(DeviceType.newInstance(deviceTypeDescription));
	}

	public class DeviceTypeAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 1944478993212099527L;
	}
}
