package org.reparationservice.inmemory.entities.customer;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(HierarchicalContextRunner.class)
public class DeviceTest {
	private static final DateTime REP_CREATION_DATE_1 = DateTime.now();
	private static final DateTime REP_CREATION_DATE_2 = REP_CREATION_DATE_1
			.plusDays(1);
	private static final int INVALID_SERIAL_NUMBER = -1;
	private static final DateTime ANY_CREATION_DATE = null;
	private Device device;
	private static final int SERIAL_NUMBER = 150;

	@Before
	public void givenDevice() {
		device = InMemoryConfigurator.getNewDevice(SERIAL_NUMBER);
	}

	@Test
	public void creation() {
		assertThat(device).isNotNull();
		assertThat(device.getSerialNumber()).isEqualTo(SERIAL_NUMBER);
	}

	public class ReparationOps
	{
		private static final String REP_FAILURE = "failure";

		@Test
		public void getReparation() {
			device.addReparation(newRepDTO(REP_CREATION_DATE_1));
			device.addReparation(newRepDTO(REP_CREATION_DATE_2));

			Reparation reparation1 = device
					.getReparation(REP_CREATION_DATE_1);
			assertThat(reparation1).isNotNull();
			assertThat(reparation1.getCreationDate()).isEqualTo(
					REP_CREATION_DATE_1);
			Reparation reparation2 = device
					.getReparation(REP_CREATION_DATE_2);
			assertThat(reparation2).isNotNull();
			assertThat(reparation2.getCreationDate()).isEqualTo(
					REP_CREATION_DATE_2);
		}

		private ReparationDTO newRepDTO(DateTime creationDate) {
			return new ReparationDTO(creationDate, REP_FAILURE);
		}
	}
}
