package org.reparationservice.entities.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;

public class ReparationTest {
	private static final DateTime INVALID_CREATION_DATE = null;
	private static final String EMPTY_FAILURE = "";

	@Test
	public void testSpecialCase() {
		Reparation rep = Reparation.NULL;
		assertThat(rep).isNotNull();
		assertThat(rep.getCreationDate()).isEqualTo(INVALID_CREATION_DATE);
		assertThat(rep.getDeviceFailure()).isEqualTo(EMPTY_FAILURE);
	}
}
