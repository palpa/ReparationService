package reparationservice.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DeviceTypeTest {
	@Test
	public void getEmptyDescriptionWhenDeviceTypeSpecialCase() {
		assertThat(DeviceType.NULL.getDescription()).isEqualTo("");
	}
}
