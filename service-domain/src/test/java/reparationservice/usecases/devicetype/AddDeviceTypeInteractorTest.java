package reparationservice.usecases.devicetype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGatewaySpy;
import reparationservice.requestor.UseCaseActivator;
import reparationservice.requestor.UseCaseRequest;
import reparationservice.usecases.devicetype.AddDeviceTypeInteractor;
import reparationservice.usecases.devicetype.AddDeviceTypeRequest;

public class AddDeviceTypeInteractorTest {
	private static final String DEVICE_TYPE_DESCRIPTION = "Description";
	private DeviceTypeGatewaySpy devTypesSpy;
	private UseCaseActivator addDeviceType;

	@Before
	public void givenAddDeviceTypeInteractor() {
		devTypesSpy = new DeviceTypeGatewaySpy();
		UseCaseRequest request = new AddDeviceTypeRequest(DEVICE_TYPE_DESCRIPTION);
		addDeviceType = new AddDeviceTypeInteractor(devTypesSpy, request);
		
	}

	@Test
	public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isFalse();
	}

	@Test
	public void executeAddOperation() {
		addDeviceType.execute(null);
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isTrue();
		DeviceType deviceType = devTypesSpy.getDeviceType();
		assertThat(deviceType.getDescription()).isEqualTo(
				DEVICE_TYPE_DESCRIPTION);
	}

	@Test(expected = AddDeviceTypeInteractor.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {
		addDeviceType.execute(null);
		addDeviceType.execute(null);
	}
}
