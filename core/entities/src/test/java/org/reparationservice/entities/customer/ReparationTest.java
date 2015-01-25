package org.reparationservice.entities.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class ReparationTest {
	private static final String FAILURE = "failure";
	private static final DateTime CREATION_DATE = DateTime.now();
	private static final Object INVALID_CREATION_DATE = null;
	private static final Object EMPTY_FAILURE = "";
	private ReparationDTO reparationDTO;

	@Before
	public void givenReparationDTO() {
		reparationDTO = new ReparationDTO(CREATION_DATE, FAILURE);
	}

	@Test
	public void testReparationDTO() {
		assertThat(reparationDTO).isNotNull();
		assertThat(reparationDTO.getCreationDate()).isEqualTo(CREATION_DATE);
		assertThat(reparationDTO.getFailure()).isEqualTo(FAILURE);
	}

	@Test
	public void testSpecialCase() {
		Reparation rep = Reparation.NULL;
		assertThat(rep).isNotNull();
		assertThat(rep.getCreationDate()).isEqualTo(INVALID_CREATION_DATE);
		assertThat(rep.getFailure()).isEqualTo(EMPTY_FAILURE);
	}
}
