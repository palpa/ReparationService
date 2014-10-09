package reparationservice.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.dtos.ReparationDTO;
import reparationservice.entities.impl.DeviceImpl;

@RunWith(HierarchicalContextRunner.class)
public class DeviceTest {
	private static final int SERIAL_NUMBER = 150;
	private static final DateTime REP_CREATION_DATE = DateTime.now();
	private Device device;

	@Before
	public void givenDevice() {
		device = new DeviceImpl(SERIAL_NUMBER);
	}

	@Test
	public void testImpl() {
		assertThat(device).isNotNull();
		assertThat(device.getSerialNumber()).isEqualTo(SERIAL_NUMBER);
	}

	public class ReparationOps
	{
		private ReparationDTO reparationDTO;

		@Before
		public void givenReparationDTO() {
			reparationDTO = new ReparationDTO(REP_CREATION_DATE);
		}

		@Test
		public void testReparationDTO() {
			assertThat(reparationDTO).isNotNull();
			assertThat(reparationDTO.getCreationDate()).isEqualTo(REP_CREATION_DATE);
		}

		@Ignore
		@Test
		public void getReparation() {
			device.addReparation(reparationDTO);
			Reparation reparation = device.getReparation(REP_CREATION_DATE);
			assertThat(reparation).isNotNull();
			assertThat(reparation.getCreationDate()).isEqualTo(REP_CREATION_DATE);
		}
	}
}
