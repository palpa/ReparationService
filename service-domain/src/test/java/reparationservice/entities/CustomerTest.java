package reparationservice.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CustomerTest {

	private static final long CUSTOMER_1_ID = 1;
	private static final long CUSTOMER_2_ID = 2;

	@Test
	public void createCustomer() {
		Customer customer1 = Customer.newInstance(CUSTOMER_1_ID);
		Customer customer2 = Customer.newInstance(CUSTOMER_2_ID);
		
		assertThat(customer1).isNotNull();
		assertThat(customer2).isNotNull();
		assertThat(customer1.getId()).isEqualTo(CUSTOMER_1_ID);
		assertThat(customer2.getId()).isEqualTo(CUSTOMER_2_ID);
	}
}
