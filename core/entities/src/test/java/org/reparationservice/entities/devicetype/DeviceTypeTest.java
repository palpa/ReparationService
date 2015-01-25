package org.reparationservice.entities.devicetype;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DeviceTypeTest {
	private static final String EMPTY_DEVICE_DESCRIPTION = "";

	@Test
	public void testDeviceTypeSpecialCase() {
		DeviceType nullDevice = DeviceType.NULL;
		assertThat(nullDevice).isNotNull();
		assertThat(nullDevice.getDescription()).isEqualTo(EMPTY_DEVICE_DESCRIPTION);
	}
}
