package org.reparationservice.inmemory.entities.devicetype;

import org.junit.Test;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.inmemory.InMemoryConfigurator;

import static org.assertj.core.api.Assertions.assertThat;

public class DeviceTypeTest {
	private static final String DEVICE_DESCRIPTION = "description";

	@Test
	public void testDeviceTypeImpl() {
		DeviceType device = InMemoryConfigurator.getNewDeviceType(DEVICE_DESCRIPTION);
		assertThat(device).isNotNull();
		assertThat(device.getDescription()).isEqualTo(DEVICE_DESCRIPTION);
	}
}
