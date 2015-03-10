package org.reparationservice.usecases.devicetype.add;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import org.reparationservice.doubles.DeviceTypeGatewaySpy;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

public class AddDeviceTypeInteractorTest {
	private static final String DEVICE_TYPE_DESCRIPTION = "Description";
	private DeviceTypeGatewaySpy devTypesSpy;
	private UseCaseActivator addDeviceType;
  private UseCaseRequest request;

  @Before
	public void givenAddDeviceTypeInteractor() {
		devTypesSpy = new DeviceTypeGatewaySpy();
    request = new AddDeviceTypeRequest(DEVICE_TYPE_DESCRIPTION);
		addDeviceType = new AddDeviceTypeInteractor(devTypesSpy, request);
	}

	@Test
	public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isFalse();
	}

	@Test
	public void executeAddOperation() {
		addDeviceType.execute(request);
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isTrue();
		DeviceType deviceType = devTypesSpy.getDeviceType();
		assertThat(deviceType.getDescription()).isEqualTo(
				DEVICE_TYPE_DESCRIPTION);
	}

	@Test(expected = AddDeviceTypeInteractor.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {
		addDeviceType.execute(request);
		addDeviceType.execute(request);
	}
}
