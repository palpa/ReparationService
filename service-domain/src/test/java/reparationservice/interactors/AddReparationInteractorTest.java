package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.doubles.CustomerGatewaySpy;
import reparationservice.doubles.NotEmptyCustomerSpy;
import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddReparationRequest;
import reparationservice.requests.Request;

@RunWith(HierarchicalContextRunner.class)
public class AddReparationInteractorTest {
	private static final int CUSTOMER_ID = NotEmptyCustomerSpy.CUSTOMER_ID;
	private static final String DEVICE_FAILURE = "failure";
	private static final DateTime CREATION_DATE = DateTime.now();
	private static final int DEVICE_SERIAL_NUMBER = 5;
	private static final String REPARATION_OBSERVATIONS = "observations";
	private static final String REPARATION_URGENCY = "urgency";

	private Interactor addReparation;
	private Request request;

	@Before
	public void givenRequest() throws Exception {
		request = createRequest();
	}

	@Test
	public void checkReparationRequest() {
		AddReparationRequest repReq = (AddReparationRequest) request;
		assertThat(repReq.getCustomerId()).isEqualTo(CUSTOMER_ID);
		assertThat(repReq.getCreationDate()).isEqualTo(CREATION_DATE);
		assertThat(repReq.getDeviceSerialNumber()).isEqualTo(
				DEVICE_SERIAL_NUMBER);
		assertThat(repReq.getDeviceFailure()).isEqualTo(DEVICE_FAILURE);
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

		@Test(expected = AddReparationInteractor.DeviceNotFound.class)
		public void throwDeviceNotFoundWhenDeviceSerialNumberNotFound() {
			addReparation.execute(request);
		}
	}

	private Request createRequest() {
		return new AddReparationRequest(CUSTOMER_ID, DEVICE_SERIAL_NUMBER,
				CREATION_DATE, DEVICE_FAILURE, REPARATION_URGENCY,
				REPARATION_OBSERVATIONS);
	}
}
