package reparationservice.interactors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Customer;
import reparationservice.gateways.CustomerGateway;
import reparationservice.requests.AddCustomerRequest;
import reparationservice.requests.Request;

public class AddCustomerInteractorTest {
	private static final long CUSTOMER_ID = 1;

	@Test
	public void creation() {
		CustomerGateway customers = new ReparationService();
		Interactor addCustomer = new AddCustomerInteractor(customers);
		Request request = new AddCustomerRequest(CUSTOMER_ID);
		
		addCustomer.execute(request);

		Customer recoveredCustomer = customers.getCustomerById(CUSTOMER_ID);
		assertThat(recoveredCustomer).isNotNull();
		assertThat(recoveredCustomer.getId()).isEqualTo(CUSTOMER_ID);
	}
}
