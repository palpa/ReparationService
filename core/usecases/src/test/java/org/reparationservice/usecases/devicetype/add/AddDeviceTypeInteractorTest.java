package reparationservice.usecases.devicetype.add;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.devicetype.DeviceType;
import reparationservice.entities.devicetype.DeviceTypeGatewaySpy;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

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
		addDeviceType.execute();
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isTrue();
		DeviceType deviceType = devTypesSpy.getDeviceType();
		assertThat(deviceType.getDescription()).isEqualTo(
				DEVICE_TYPE_DESCRIPTION);
	}

	@Test(expected = AddDeviceTypeInteractor.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {
		addDeviceType.execute();
		addDeviceType.execute();
	}
}
