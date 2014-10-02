package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.ReparationService;
import reparationservice.entities.Customer;
import reparationservice.entities.Reparation;
import reparationservice.gateways.CustomerGateway;

@RunWith(HierarchicalContextRunner.class)
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
		addReparation = new AddReparationInteractor(creationDate, failure,
				urgency, observations, customerId, deviceSerialNumber,
				customers);
	}

	@Test(expected = AddReparationInteractor.CustomerNotFound.class)
	public void throwCustomerNotFoundWhenProvidedCustomerIdDontMatchWithAnyCustomer() {
		addReparation.execute();
	}

	public class CustomerIsFoundWhenExecuteAddOperation {
		@Before
		public void givenCustomer() {
			Interactor addCustomer = new AddCustomerInteractor(customerId,
					customers);
			addCustomer.execute();
		}

		@Ignore
		@Test
		public void testAddReparation() {
			addReparation.execute();

			Customer customer = customers.getCustomerById(customerId);
			assertThat(customer).isNotNull();
			assertThat(customer).isNotEqualTo(Customer.NULL);
			
			Reparation reparation = customer.getReparation(deviceSerialNumber,
					creationDate);
			assertThat(reparation).isNotNull();
			assertThat(reparation.getCreationDate()).isEqualTo(creationDate);
		}
	}
}
