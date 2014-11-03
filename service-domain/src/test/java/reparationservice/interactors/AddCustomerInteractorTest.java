package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.doubles.CustomerGatewaySpy;
import reparationservice.entities.Customer;
import reparationservice.interactors.requests.AddCustomerRequest;
import reparationservice.requestor.UseCaseActivator;

public class AddCustomerInteractorTest {
	private static final long CUSTOMER_ID = 1;
	private CustomerGatewaySpy customersSpy;

	@Before
	public void setUp() {
		customersSpy = new CustomerGatewaySpy();
	}

	@Test
	public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
		assertThat(customersSpy.addCustomerWasCalled()).isFalse();
	}

	@Test
	public void executeOperation() {
		UseCaseActivator addCustomer = new AddCustomerInteractor(customersSpy);
		
		addCustomer.execute(new AddCustomerRequest(CUSTOMER_ID));

		assertThat(customersSpy.addCustomerWasCalled()).isTrue();
		Customer addedCustomer = customersSpy.getCustomer();
		assertThat(addedCustomer).isNotNull();
		assertThat(addedCustomer.getId()).isEqualTo(CUSTOMER_ID);
	}
}
