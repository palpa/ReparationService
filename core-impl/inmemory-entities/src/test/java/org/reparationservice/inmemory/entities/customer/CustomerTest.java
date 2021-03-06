package org.reparationservice.inmemory.entities.customer;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reparationservice.entities.customer.Customer;
import org.reparationservice.entities.customer.Device;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(HierarchicalContextRunner.class)
public class CustomerTest {
	private static final long DEVICE_SERIAL_NUMBER_1 = 300;
	private static final int DEVICE_SERIAL_NUMBER_2 = 2;
	private static final long CUSTOMER_1_ID = 1;
	private static final long CUSTOMER_2_ID = 2;

	private Customer customer1;

	@Before
	public void givenCustomer() {
		customer1 = createCustomer(CUSTOMER_1_ID);
	}

	@Test
	public void testCreation() {
		Customer customer2 = createCustomer(CUSTOMER_2_ID);

		assertThat(customer1).isNotNull();
		assertThat(customer2).isNotNull();
		assertThat(customer1.getId()).isEqualTo(CUSTOMER_1_ID);
		assertThat(customer2.getId()).isEqualTo(CUSTOMER_2_ID);
	}

	@Test
	public void returnNullDeviceWhenSerialNumberNotFound() {
		Device device = customer1.getDevice(DEVICE_SERIAL_NUMBER_1);
		assertThat(device).isNotNull();
		assertThat(device).isEqualTo(Device.NULL);
	}

	@Test
	public void addDevice() {
		customer1.addDevice(DEVICE_SERIAL_NUMBER_1);
		customer1.addDevice(DEVICE_SERIAL_NUMBER_2);

		assertDevice(customer1.getDevice(DEVICE_SERIAL_NUMBER_1),
				DEVICE_SERIAL_NUMBER_1);
		assertDevice(customer1.getDevice(DEVICE_SERIAL_NUMBER_2),
				DEVICE_SERIAL_NUMBER_2);
	}

	private void assertDevice(Device device, long deviceSerialNumber) {
		assertThat(device).isNotNull();
		assertThat(device).isNotEqualTo(Device.NULL);
		assertThat(device.getSerialNumber()).isEqualTo(deviceSerialNumber);
	}

	private Customer createCustomer(long customerId) {
    return new CustomerImpl(customerId);
  }
}
