package org.reparationservice.doubles;

public class CustomerGatewaySpy implements CustomerGateway {
	protected Customer customer;
	
	public CustomerGatewaySpy() {
		customer = Customer.NULL;
	}

	@Override
	public Customer getCustomerById(long customerId) {
		return customer;
	}

	@Override
	public void addCustomer(final long customerId) {
		customer = new Customer() {
			@Override
			public long getId() {
				return customerId;
			}

			@Override
			public Device getDevice(long deviceSerialNumber) {
				return null;
			}

			@Override
			public void addDevice(long deviceSerialNumber) {

			}
		};
	}

	public boolean addCustomerWasCalled() {
		return customer != Customer.NULL;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
