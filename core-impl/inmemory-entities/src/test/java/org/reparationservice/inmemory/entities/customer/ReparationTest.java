package org.reparationservice.inmemory.entities.customer;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReparationTest {
	private static final String FAILURE = "failure";
	private static final DateTime CREATION_DATE = DateTime.now();
	private ReparationDTO reparationDTO;

	@Before
	public void givenReparationDTO() {
		reparationDTO = new ReparationDTO(CREATION_DATE, FAILURE);
	}

	@Test
	public void createReparation() {
		Reparation rep = InMemoryConfigurator.getNewReparation(reparationDTO);
		assertThat(rep).isNotNull();
		assertThat(rep.getCreationDate()).isEqualTo(CREATION_DATE);
		assertThat(rep.getFailure()).isEqualTo(FAILURE);
	}
}
