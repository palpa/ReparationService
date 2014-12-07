package reparationservice.usecases.devicetype.add;

import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGateway;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;

public final class AddDeviceTypeInteractor implements UseCaseActivator {
	private final DeviceTypeGateway deviceTypes;
  private final UseCaseRequest request;

	public AddDeviceTypeInteractor(DeviceTypeGateway deviceTypes, UseCaseRequest request) {
		this.deviceTypes = deviceTypes;
		this.request = request;
	}

	@Override
	public void execute() {
		AddDeviceTypeRequest dtReq = (AddDeviceTypeRequest) this.request;
		String deviceTypeDescription = dtReq.getDescription();
		
		if (deviceTypes.getDeviceTypeBy(deviceTypeDescription) != DeviceType.NULL)
			throw new DeviceTypeAlreadyExists();

		deviceTypes.addDeviceType(deviceTypeDescription);
	}

	public class DeviceTypeAlreadyExists extends RuntimeException {
		private static final long serialVersionUID = 1944478993212099527L;
	}
}
