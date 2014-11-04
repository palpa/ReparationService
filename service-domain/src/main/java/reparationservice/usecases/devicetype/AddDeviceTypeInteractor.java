package reparationservice.usecases.devicetype;

import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGateway;
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
