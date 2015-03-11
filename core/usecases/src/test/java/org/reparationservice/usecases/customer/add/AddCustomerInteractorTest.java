package org.reparationservice.usecases.customer.add;

import static org.assertj.core.api.Assertions.assertThat;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.reparationservice.doubles.CustomerGatewaySpy;
import org.reparationservice.entities.customer.Customer;
import org.reparationservice.requestor.UseCaseActivator;

@RunWith(HierarchicalContextRunner.class)
public class AddCustomerInteractorTest {
  private static final long CUSTOMER_ID = 1;
  private CustomerGatewaySpy customersSpy;

  @Before
  public void setUp() {
    customersSpy = new CustomerGatewaySpy();
  }

  @Test
  public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
    assertThat(customersSpy.addCustomerWasCalled()).isFalse();
  }

  @Test(expected = AddCustomerInteractor.CustomerGatewayCannotBeNull.class)
  public void customerGatewayCannotBeNull() {
    new AddCustomerInteractor(null);
  }

  public class InteractorCreated {
    private UseCaseActivator addCustomer;

    @Before
    public void givenInteractor(){
      addCustomer = new AddCustomerInteractor(customersSpy);
    }

    @Test(expected = AddCustomerInteractor.RequestCannotBeNull.class)
    public void requestCannotBeNull() {
      addCustomer.execute(null);
    }

    @Test
    public void executeOperation() {
      AddCustomerRequest request = new AddCustomerRequest(CUSTOMER_ID);
      addCustomer.execute(request);

      assertThat(customersSpy.addCustomerWasCalled()).isTrue();
      Customer addedCustomer = customersSpy.getCustomer();
      assertThat(addedCustomer).isNotNull();
      assertThat(addedCustomer.getId()).isEqualTo(CUSTOMER_ID);
    }
  }
}
