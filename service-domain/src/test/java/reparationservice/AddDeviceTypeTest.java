package reparationservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.DeviceType;
import reparationservice.gateways.DeviceTypeGateway;

public class AddDeviceTypeTest {
	private static final String DEVICE_TYPE_DESCRIPTION_1 = "Description";
	private static final String DEVICE_TYPE_DESCRIPTION_2 = "Description2";
	private DeviceTypeGateway gateway;

	private DeviceType newDeviceType1() {
		return DeviceType.newInstance(DEVICE_TYPE_DESCRIPTION_1);
	}
	
	private DeviceType newDeviceType2() {
		return DeviceType.newInstance(DEVICE_TYPE_DESCRIPTION_2);
	}

	@Before
	public void givenDeviceTypeGateway() {
		gateway = new ReparationService();
	}

	@Test
	public void returnNullWhenDeviceTypeNotExists() {
		assertThat(gateway.getDeviceType(DEVICE_TYPE_DESCRIPTION_1)).isNull();
	}
	
	@Test(expected = DeviceTypeGateway.DeviceTypeAlreadyExists.class)
	public void throwDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {
		gateway.addDeviceType(newDeviceType1());
		gateway.addDeviceType(newDeviceType1());
	}

	@Test
	public void addDeviceTypes() {
		gateway.addDeviceType(newDeviceType1());
		gateway.addDeviceType(newDeviceType2());

		assertThat(
				gateway.getDeviceType(DEVICE_TYPE_DESCRIPTION_1)
						.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION_1);
		assertThat(
				gateway.getDeviceType(DEVICE_TYPE_DESCRIPTION_2)
						.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION_2);
	}
}
