package org.reparationservice.inmemory.entities.devicetype;

import org.junit.Before;
import org.junit.Test;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.entities.devicetype.DeviceTypeGateway;
import org.reparationservice.inmemory.InMemoryConfigurator;

import static org.assertj.core.api.Assertions.assertThat;

public class DeviceTypeGatewayTest {
	private static final String DEVICE_TYPE_DESCRIPTION_1 = "Description1";
	private static final String DEVICE_TYPE_DESCRIPTION_2 = "Description2";
	private DeviceTypeGateway deviceTypes;

	@Before
	public void givenDeviceTypeGateway() {
		deviceTypes = InMemoryConfigurator.getDeviceTypeGateway();
	}

	@Test
	public void returnSpecialCaseWhenDeviceTypeNotExists() {
		assertThat(deviceTypes.getDeviceTypeBy(DEVICE_TYPE_DESCRIPTION_1)).
				isEqualTo(DeviceType.NULL);
	}

	@Test
	public void testAddDeviceTypes() {
		deviceTypes.addDeviceType(DEVICE_TYPE_DESCRIPTION_1);
		deviceTypes.addDeviceType(DEVICE_TYPE_DESCRIPTION_2);

		assertThat(
				deviceTypes.getDeviceTypeBy(DEVICE_TYPE_DESCRIPTION_1)
						.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION_1);
		assertThat(
				deviceTypes.getDeviceTypeBy(DEVICE_TYPE_DESCRIPTION_2)
						.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION_2);
	}
}
