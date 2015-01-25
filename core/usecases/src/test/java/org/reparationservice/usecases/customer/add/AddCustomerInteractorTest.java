package reparationservice.usecases.customer.add;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.entities.customer.Customer;
import reparationservice.entities.customer.CustomerGatewaySpy;
import org.reparationservice.requestor.UseCaseActivator;

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
	  AddCustomerRequest request = new AddCustomerRequest(CUSTOMER_ID);
		UseCaseActivator addCustomer = new AddCustomerInteractor(customersSpy, request);
			
    addCustomer.execute();

		assertThat(customersSpy.addCustomerWasCalled()).isTrue();
		Customer addedCustomer = customersSpy.getCustomer();
		assertThat(addedCustomer).isNotNull();
		assertThat(addedCustomer.getId()).isEqualTo(CUSTOMER_ID);
	}
}
