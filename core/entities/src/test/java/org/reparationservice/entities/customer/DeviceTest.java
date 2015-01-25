package org.reparationservice.entities.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

public class DeviceTest {
	private static final DateTime REP_CREATION_DATE_1 = DateTime.now();
	private static final int INVALID_SERIAL_NUMBER = -1;
	private static final DateTime ANY_CREATION_DATE = null;
	private Device device;

	@Test
	public void testSpecialCase() {
		device = Device.NULL;
		assertThat(device).isNotNull();
		assertThat(device.getSerialNumber()).isEqualTo(INVALID_SERIAL_NUMBER);
		assertThat(device.toString()).isEqualTo("Null Device");
		ReparationDTO anyRepDTO = null;
		device.addReparation(anyRepDTO);
		assertThat(device.getReparation(ANY_CREATION_DATE)).isEqualTo(
				Reparation.NULL);
	}
}
