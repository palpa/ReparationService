package org.reparationservice.datanucleus.entities.customer;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.reparationservice.datanucleus.DatanucleusConfigurator;
import org.reparationservice.entities.customer.Reparation;
import org.reparationservice.entities.customer.ReparationDTO;

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
		Reparation rep = DatanucleusConfigurator.instance.getNewReparation(reparationDTO);
		assertThat(rep).isNotNull();
		assertThat(rep.getCreationDate()).isEqualTo(CREATION_DATE);
		assertThat(rep.getFailure()).isEqualTo(FAILURE);
	}
}