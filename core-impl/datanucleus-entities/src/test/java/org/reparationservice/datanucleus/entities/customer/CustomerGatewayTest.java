package org.reparationservice.datanucleus.entities.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.reparationservice.datanucleus.DatanucleusConfigurator;
import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.customer.CustomerGateway;

public class CustomerGatewayTest {
	private static final int CUSTOMER_1_ID = 1;
	private static final int CUSTOMER_2_ID = 2;
	private CustomerGateway customers;

	@Before
	public void givenCustomerGateway() {
		customers = DatanucleusConfigurator.instance.getCustomerGateway();
	}

	@Test
	public void returnSpecialCaseWhenDeviceTypeNotExists() {
		Assertions.assertThat(customers.getCustomerById(CUSTOMER_1_ID)).
				isEqualTo(Customer.NULL);
	}

	@Test
	public void addCustomers() {
		customers.addCustomer(CUSTOMER_1_ID);
		customers.addCustomer(CUSTOMER_2_ID);

		Customer recoveredCustomer = customers.getCustomerById(CUSTOMER_1_ID);
		assertThat(recoveredCustomer).isNotNull();
		Assertions.assertThat(recoveredCustomer.getId()).isEqualTo(CUSTOMER_1_ID);
		recoveredCustomer = customers.getCustomerById(CUSTOMER_2_ID);
		assertThat(recoveredCustomer).isNotNull();
		Assertions.assertThat(recoveredCustomer.getId()).isEqualTo(CUSTOMER_2_ID);
	}
}
