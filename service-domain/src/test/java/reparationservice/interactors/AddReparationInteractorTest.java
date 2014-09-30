package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Customer;
import reparationservice.entities.Reparation;
import reparationservice.gateways.CustomerGateway;

public class AddReparationInteractorTest {

	private Interactor addReparation;
	private CustomerGateway customers;
	private final DateTime creationDate = new DateTime();
	private final long customerId = 0;
	private final long deviceSerialNumber = 0;

	@Before
	public void setUp() throws Exception {
		customers = new ReparationService();
		String failure = "";
		String urgency = "";
		String observations = "";
		addReparation = new AddReparationInteractor(creationDate, failure, urgency, observations, customerId, deviceSerialNumber, customers);
	}

	@Ignore
	@Test
	public void testAddReparation() {
		addReparation.execute();
		
		Customer customer = customers.getCustomerById(customerId);
		Reparation reparation = customer.getReparation(deviceSerialNumber,
				creationDate);
		assertThat(reparation.getCreationDate()).isEqualTo(creationDate);
	}
	
	@Test(expected = AddReparationInteractor.CustomerNotFound.class)
	public void throwCustomerNotFoundWhenProvidedCustomerIdDontMatchWithAnyCustomer() {
		addReparation.execute();
	}

}
