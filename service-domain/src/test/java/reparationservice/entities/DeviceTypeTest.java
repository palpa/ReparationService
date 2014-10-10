package reparationservice.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import reparationservice.Configurator;

public class DeviceTypeTest {
	private static final String EMPTY_DEVICE_DESCRIPTION = "";
	private static final String DEVICE_DESCRIPTION = "description";

	@Test
	public void testDeviceTypeSpecialCase() {
		DeviceType nullDevice = DeviceType.NULL;
		assertThat(nullDevice).isNotNull();
		assertThat(nullDevice.getDescription()).isEqualTo(EMPTY_DEVICE_DESCRIPTION);
	}
	
	@Test
	public void testDeviceTypeImpl() {
		DeviceType device = Configurator.getNewDeviceType(DEVICE_DESCRIPTION);
		assertThat(device).isNotNull();
		assertThat(device.getDescription()).isEqualTo(DEVICE_DESCRIPTION);
	}
}
