package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.DeviceType;
import reparationservice.gateways.DeviceTypeGateway;

public class AddDeviceTypeInteractorTest {
	
	private static final String DEVICE_TYPE_DESCRIPTION = "Description";
	private DeviceTypeGateway deviceTypes;
	private Interactor addDeviceType;

	@Before
	public void givenAddDeviceTypeInteractor() {
		deviceTypes = new ReparationService();
		addDeviceType = new AddDeviceTypeInteractor(DEVICE_TYPE_DESCRIPTION, deviceTypes);
	}
	
	@Test
	public void executeAddOperation() {
		addDeviceType.execute();
		DeviceType deviceType = deviceTypes.getDeviceTypeBy(DEVICE_TYPE_DESCRIPTION);
		assertThat(deviceType.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION);
	}

	@Test(expected = AddDeviceTypeInteractor.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {		
		addDeviceType.execute();
		addDeviceType.execute();
	}
}
