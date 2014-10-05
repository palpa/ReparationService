package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.doubles.CustomerGatewaySpy;
import reparationservice.doubles.NotEmptyCustomerSpy;
import reparationservice.entities.Customer;
import reparationservice.entities.Reparation;
import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddReparationRequest;
import reparationservice.requests.Request;

@RunWith(HierarchicalContextRunner.class)
public class AddReparationInteractorTest {
	private static final int CUSTOMER_ID = NotEmptyCustomerSpy.CUSTOMER_ID;
	private static final String DEVICE_FAILURE_1 = "failure1";
	public static final String DEVICE_FAILURE_2 = "failure2";
	private static final DateTime CREATION_DATE_1 = DateTime.now();
	private static final DateTime CREATION_DATE_2 = CREATION_DATE_1.plusDays(1);
	private static final int DEVICE_SERIAL_NUMBER = 5;
	private static final String REPARATION_OBSERVATIONS = "observations";
	private static final String REPARATION_URGENCY = "urgency";

	private Interactor addReparation;
	private Request request;

	@Before
	public void givenRequest() throws Exception {
		request = createRequest(CREATION_DATE_1, DEVICE_FAILURE_1);
	}
	
	@Test
	public void checkReparationRequest() {
		AddReparationRequest repReq = (AddReparationRequest) request;
		assertThat(repReq.getCustomerId()).isEqualTo(CUSTOMER_ID);
		assertThat(repReq.getCreationDate()).isEqualTo(CREATION_DATE_1);
		assertThat(repReq.getDeviceSerialNumber()).isEqualTo(DEVICE_SERIAL_NUMBER);
		assertThat(repReq.getDeviceFailure()).isEqualTo(DEVICE_FAILURE_1);
	}

	@Test(expected = AddReparationInteractor.CustomerNotFound.class)
	public void throwCustomerNotFoundWhenProvidedCustomerIdDontMatchWithAnyCustomer() {
		CustomerGateway emptyCustomersSpy = new CustomerGatewaySpy();
		addReparation = new AddReparationInteractor(emptyCustomersSpy);
		addReparation.execute(request);
	}

	public class CustomerIsFoundWhenExecuteAddOperation {
		private NotEmptyCustomerSpy notEmptyCustomerSpy;

		@Before
		public void givenCustomer() {
			notEmptyCustomerSpy = new NotEmptyCustomerSpy();
			addReparation = new AddReparationInteractor(notEmptyCustomerSpy);
		}

		@Ignore
		@Test
		public void testAddReparation() {
			addReparation.execute(request);
			addReparation.execute(createRequest(CREATION_DATE_2,
					DEVICE_FAILURE_2));

			Customer customer = notEmptyCustomerSpy.getCustomer();
			assertThat(customer).isNotNull();
			assertThat(customer).isNotEqualTo(Customer.NULL);

			Reparation reparation1 = customer.getReparation(
					DEVICE_SERIAL_NUMBER, CREATION_DATE_1);
			Reparation reparation2 = customer.getReparation(
					DEVICE_SERIAL_NUMBER, CREATION_DATE_2);

			assertThat(reparation1).isNotNull();
			assertThat(reparation2).isNotNull();
			assertThat(reparation1.getCreationDate())
					.isEqualTo(CREATION_DATE_1);
			assertThat(reparation2.getCreationDate())
					.isEqualTo(CREATION_DATE_2);
			assertThat(reparation1.getDeviceFailure()).isEqualTo(DEVICE_FAILURE_1);
			//assertThat(reparation2.getDeviceFailure()).isEqualTo(DEVICE_FAILURE_2);
		}
	}

	private Request createRequest(DateTime creationDate, String deviceFailure) {
		return new AddReparationRequest(CUSTOMER_ID, DEVICE_SERIAL_NUMBER,
				creationDate, deviceFailure, REPARATION_URGENCY,
				REPARATION_OBSERVATIONS);
	}
}
