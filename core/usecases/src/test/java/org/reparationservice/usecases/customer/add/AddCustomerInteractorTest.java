package org.reparationservice.usecases.customer.add;

import static org.assertj.core.api.Assertions.assertThat;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.reparationservice.doubles.CustomerGatewaySpy;
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
    assertThat(customersSpy.addCustomerTimesCalled()).isEqualTo(0);
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

      assertThat(customersSpy.addCustomerTimesCalled()).isEqualTo(1);
      assertThat(customersSpy.addCustomerWasCalledWith(CUSTOMER_ID)).isTrue();

    }
  }
}
