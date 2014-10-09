package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import reparationservice.doubles.CusromerWithDeviceSpy;
import reparationservice.doubles.CustomerGatewaySpy;
import reparationservice.doubles.NotEmptyCustomerSpy;
import reparationservice.entities.Customer;
import reparationservice.entities.Device;
import reparationservice.entities.Reparation;
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

	public class CustomerIsFound {
		@Before
		public void givenCustomer() {
			CustomerGateway notEmptyCustomerSpy = new NotEmptyCustomerSpy();
			addReparation = new AddReparationInteractor(notEmptyCustomerSpy);
		}

		@Test(expected = AddReparationInteractor.DeviceNotFound.class)
		public void throwDeviceNotFoundWhenDeviceSerialNumberNotFound() {
			addReparation.execute(request);
		}

		public class DeviceIsFound {
			private CustomerGatewaySpy customerWithDeviceSpy;

			@Before
			public void givenDevice() {
				customerWithDeviceSpy = new CusromerWithDeviceSpy();
				addReparation = new AddReparationInteractor(
						customerWithDeviceSpy);
			}

			@Ignore
			@Test
			public void addReparation() {
				// addReparation.execute(request);
				// cusromerWithDeviceSpy.getCustomer()
				Reparation reparation = getReparation(DEVICE_SERIAL_NUMBER,
						CREATION_DATE, customerWithDeviceSpy);
				assertThat(reparation).isNotNull();
				assertThat(reparation.getCreationDate()).isEqualTo(
						CREATION_DATE);
			}

			private Reparation getReparation(int deviceSerialNumber,
					DateTime creationDate, CustomerGatewaySpy customerGatewaySpy) {
				Customer customer = customerGatewaySpy.getCustomer();
				assertThat(customer).isNotNull();
				Device device = customer.getDevice(deviceSerialNumber);
				assertThat(device).isNotNull();
				Reparation reparation = device.getReparation(creationDate);
				assertThat(customer).isNotNull();
				return reparation;
			}
		}
	}

	private Request createRequest() {
		return new AddReparationRequest(CUSTOMER_ID, DEVICE_SERIAL_NUMBER,
				CREATION_DATE, DEVICE_FAILURE, REPARATION_URGENCY,
				REPARATION_OBSERVATIONS);
	}
}
