package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;

public class AddCustomerInteractorTest {

	private static final long CUSTOMER_ID = 1;

	@Before
	public void setUp() {
	}

	@Test
	public void creation() {
		CustomerGateway customers = new ReparationService();

		Interactor addCustomer = new AddCustomerInteractor(CUSTOMER_ID,
				customers);
		addCustomer.execute();

		Customer recoveredCustomer = customers.getCustomerById(CUSTOMER_ID);
		assertThat(recoveredCustomer).isNotNull();
		assertThat(recoveredCustomer.getId()).isEqualTo(CUSTOMER_ID);
	}

}
