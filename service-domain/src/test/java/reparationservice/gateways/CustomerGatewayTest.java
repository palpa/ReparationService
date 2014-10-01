package reparationservice.gateways;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import reparationservice.ReparationService;
import reparationservice.entities.Customer;

public class CustomerGatewayTest {
	private static final int CUSTOMER_1_ID = 1;
	private static final int CUSTOMER_2_ID = 2;

	@Test
	public void addCustomers() {
		CustomerGateway customers = new ReparationService();
		
		customers.addCustomer(Customer.newInstance(CUSTOMER_1_ID));
		customers.addCustomer(Customer.newInstance(CUSTOMER_2_ID));
		
		Customer recoveredCustomer = customers.getCustomerById(CUSTOMER_1_ID);	
		assertThat(recoveredCustomer).isNotNull();
		assertThat(recoveredCustomer.getId()).isEqualTo(CUSTOMER_1_ID);
		recoveredCustomer = customers.getCustomerById(CUSTOMER_2_ID);	
		assertThat(recoveredCustomer).isNotNull();
		assertThat(recoveredCustomer.getId()).isEqualTo(CUSTOMER_2_ID);
	}


}
