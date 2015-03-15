package org.reparationservice.doubles;

import org.joda.time.DateTime;
import org.reparationservice.entities.customer.*;

public class CustomerGatewaySpy implements CustomerGateway {
  private Customer customer = Customer.NULL;
  private int addCustomerTimesCalled = 0;
  private int addReparationCalledTimes = 0;
  private ReparationDTO repDTO;

  @Override
  public Customer getCustomerById(long customerId) {
    return customer;
  }

  @Override
  public void addCustomer(final long customerId) {
    addCustomerTimesCalled++;
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
            addReparationCalledTimes++;
            repDTO = reparationDTO;
            reparation = new Reparation() {
              @Override
              public DateTime getCreationDate() {
                return reparationDTO.getCreationDate();
              }

              @Override
              public String getDeviceFailure() {
                return reparationDTO.getDeviceFailure();
              }
            };
          }
        };
      }
    };
  }

  protected Customer getCustomer() {
    return customer;
  }

  public int addCustomerTimesCalled() {
    return addCustomerTimesCalled;
  }

  public boolean addCustomerWasCalledWith(long customerId) {
    return customer.getId() == customerId;
  }

  public int addReparationCalledTimes() {
    return addReparationCalledTimes;
  }

  public boolean addReparationWasCalledWith(ReparationDTO reparationDTO) {
    return repDTO != null && (repDTO.equals(reparationDTO));
  }
}
