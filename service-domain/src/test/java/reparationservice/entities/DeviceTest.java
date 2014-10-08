package reparationservice.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import reparationservice.entities.impl.DeviceImpl;

public class DeviceTest {
	private static final int SERIAL_NUMBER = 150;

	@Test
	public void testSpecialCase() {
		
	}
	
	@Test
	public void testImpl() {
		Device device = new DeviceImpl(SERIAL_NUMBER);
		assertThat(device).isNotNull();
		assertThat(device.getSerialNumber()).isEqualTo(SERIAL_NUMBER);	
	}
}
