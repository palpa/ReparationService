package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.DeviceType;
import reparationservice.gateways.DeviceTypeGateway;
import reparationservice.requests.AddDeviceTypeRequest;
import reparationservice.requests.Request;

public class AddDeviceTypeInteractorTest {
	private static final String DEVICE_TYPE_DESCRIPTION = "Description";
	private DeviceTypeGateway deviceTypes;
	private Interactor addDeviceType;
	private Request request;

	@Before
	public void givenAddDeviceTypeInteractor() {
		deviceTypes = new ReparationService();
		addDeviceType = new AddDeviceTypeInteractor(deviceTypes);
		request = new AddDeviceTypeRequest(DEVICE_TYPE_DESCRIPTION);
	}
	
	@Test
	public void executeAddOperation() {
		addDeviceType.execute(request);
		DeviceType deviceType = deviceTypes.getDeviceTypeBy(DEVICE_TYPE_DESCRIPTION);
		assertThat(deviceType.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION);
	}

	@Test(expected = AddDeviceTypeInteractor.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {		
		addDeviceType.execute(request);
		addDeviceType.execute(request);
	}
}
