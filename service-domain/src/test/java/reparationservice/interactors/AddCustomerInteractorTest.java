package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.gateways.CustomerGateway;

public class AddCustomerInteractorTest {

	private static final long CUSTOMER_ID = 0;

	@Before
	public void setUp() {
	}

	@Ignore
	@Test
	public void creation() {
		CustomerGateway customers = new ReparationService();
		Interactor addCustomer = new AddCustomerInteractor(CUSTOMER_ID,
				customers);
		addCustomer.execute();
		
		assertThat(customers.getCustomerById(CUSTOMER_ID).getId()).isEqualTo(CUSTOMER_ID);
	}

}
