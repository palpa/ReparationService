package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.doubles.DeviceTypeGatewaySpy;
import reparationservice.entities.DeviceType;
import reparationservice.requests.AddDeviceTypeRequest;
import reparationservice.requests.Request;

public class AddDeviceTypeInteractorTest {
	private static final String DEVICE_TYPE_DESCRIPTION = "Description";
	private DeviceTypeGatewaySpy devTypesSpy;
	private Interactor addDeviceType;
	private Request request;

	@Before
	public void givenAddDeviceTypeInteractor() {
		devTypesSpy = new DeviceTypeGatewaySpy();
		addDeviceType = new AddDeviceTypeInteractor(devTypesSpy);
		request = new AddDeviceTypeRequest(DEVICE_TYPE_DESCRIPTION);
	}

	@Test
	public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isFalse();
	}

	@Test
	public void executeAddOperation() {
		addDeviceType.execute(request);
		assertThat(devTypesSpy.addDeviceTypeWasCalled()).isTrue();
		DeviceType deviceType = devTypesSpy.getAddedDeviceType();
		assertThat(deviceType.getDescription()).isEqualTo(
				DEVICE_TYPE_DESCRIPTION);
	}

	@Test(expected = AddDeviceTypeInteractor.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {
		addDeviceType.execute(request);
		addDeviceType.execute(request);
	}
}
