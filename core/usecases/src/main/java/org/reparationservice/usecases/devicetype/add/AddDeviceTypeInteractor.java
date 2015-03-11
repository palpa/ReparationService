package org.reparationservice.usecases.devicetype.add;

import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public final class AddDeviceTypeInteractor implements UseCaseActivator {
  private final DeviceTypeGateway deviceTypes;

  public AddDeviceTypeInteractor(DeviceTypeGateway deviceTypes) {
    if (deviceTypes == null)
      throw new DeviceTypeGatewayCannotBeNull();
    this.deviceTypes = deviceTypes;
  }

  @Override
  public void execute(UseCaseRequest request) {
    if (request == null)
      throw new RequestCannotBeNull();

    AddDeviceTypeRequest dtReq = (AddDeviceTypeRequest) request;
    String deviceTypeDescription = dtReq.getDescription();

    if (deviceTypes.getDeviceTypeBy(deviceTypeDescription) != DeviceType.NULL)
      dtReq.deviceTypeAlreadyExists();
    else
      deviceTypes.addDeviceType(deviceTypeDescription);
  }

  class RequestCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = -4766180662246638550L;
  }

  class DeviceTypeGatewayCannotBeNull extends RuntimeException {
    private static final long serialVersionUID = 9214777474179091636L;
  }
}
