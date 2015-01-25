package org.reparationservice.entities.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CustomerTest {
	private static final long NULL_CUSTOMER_ID = 0;
	private static final long ANY_SERIAL_NUMBER = -1;

	@Test
	public void testSpecialCase() {
		Customer nullCustomer = Customer.NULL;
		assertThat(nullCustomer).isNotNull();
		assertThat(nullCustomer.getId()).isEqualTo(NULL_CUSTOMER_ID);
		assertThat(nullCustomer.getDevice(ANY_SERIAL_NUMBER)).isEqualTo(
				Device.NULL);
		nullCustomer.addDevice(ANY_SERIAL_NUMBER);
		assertThat(nullCustomer.getDevice(ANY_SERIAL_NUMBER)).isEqualTo(
				Device.NULL);
	}
}
