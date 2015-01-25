package org.reparationservice.doubles;

import org.joda.time.DateTime;
import org.reparationservice.entities.customer.*;

public class CustomerGatewaySpy implements CustomerGateway {
	private Customer customer;
	
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
			Device device = Device.NULL;
			@Override
			public long getId() {
				return customerId;
			}

			@Override
			public Device getDevice(long deviceSerialNumber) {
				return device;
			}

			@Override
			public void addDevice(final long deviceSerialNumber) {
				device = new Device() {
					Reparation reparation = Reparation.NULL;
					@Override
					public long getSerialNumber() {
						return deviceSerialNumber;
					}

					@Override
					public Reparation getReparation(DateTime creationDate) {
						return reparation;
					}

					@Override
					public void addReparation(final ReparationDTO reparationDTO) {
						reparation = new Reparation() {
							@Override
							public DateTime getCreationDate() {
								return reparationDTO.getCreationDate();
							}

							@Override
							public String getFailure() {
								return reparationDTO.getFailure();
							}
						};
					}
				};
			}
		};
	}

	protected void addDevice (long deviceSerialNumber){
		customer.addDevice(deviceSerialNumber);
	}

	public boolean addCustomerWasCalled() {
		return customer != Customer.NULL;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
