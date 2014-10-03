package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.doubles.CustomerGatewaySpy;
import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddCustomerRequest;
import reparationservice.requests.AddReparationRequest;
import reparationservice.requests.Request;

@RunWith(HierarchicalContextRunner.class)
public class AddReparationInteractorTest {
	private static final int CUSTOMER_ID = 1;
	private static final String DEVICE_FAILURE = "failure";
	private static final DateTime CREATION_DATE = new DateTime();
	private static final int DEVICE_SERIAL_NUMBER = 5;
	private static final String REPARATION_OBSERVATIONS = "observations";
	private static final String REPARATION_URGENCY = "urgency";
	
	private Interactor addReparation;
	private CustomerGateway customers;
	private Request request;

	@Before
	public void setUp() throws Exception {
		customers = new CustomerGatewaySpy();
		addReparation = new AddReparationInteractor(customers);
		request = new AddReparationRequest(CREATION_DATE, DEVICE_FAILURE,
				REPARATION_URGENCY, REPARATION_OBSERVATIONS, CUSTOMER_ID, DEVICE_SERIAL_NUMBER);
	}

	@Test(expected = AddReparationInteractor.CustomerNotFound.class)
	public void throwCustomerNotFoundWhenProvidedCustomerIdDontMatchWithAnyCustomer() {
		addReparation.execute(request);
	}

	public class CustomerIsFoundWhenExecuteAddOperation {
		@Before
		public void givenCustomer() {
			Interactor addCustomer = new AddCustomerInteractor(customers);
			Request addCustomerReq = new AddCustomerRequest(CUSTOMER_ID);
			addCustomer.execute(addCustomerReq);
		}

		@Test
		public void testAddReparation() {
			addReparation.execute(request);

			Customer customer = customers.getCustomerById(CUSTOMER_ID);
			assertThat(customer).isNotNull();
			assertThat(customer).isNotEqualTo(Customer.NULL);

//			Reparation reparation = customer.getReparation(deviceSerialNumber,
//					creationDate);
//			assertThat(reparation).isNotNull();
//			assertThat(reparation.getCreationDate()).isEqualTo(creationDate);
		}
	}
}
