package org.reparationservice.usecases.devicetype.add;

import static org.assertj.core.api.Assertions.assertThat;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.reparationservice.doubles.DeviceTypeGatewaySpy;
import org.reparationservice.entities.devicetype.DeviceType;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.UseCaseRequest;

@RunWith(HierarchicalContextRunner.class)
public class AddDeviceTypeInteractorTest {
  private static final String DEVICE_TYPE_DESCRIPTION = "Description";
  private DeviceTypeGatewaySpy devTypesSpy;
  private UseCaseActivator addDeviceType;
  private UseCaseRequest request;

  @Test(expected = AddDeviceTypeInteractor.DeviceTypeGatewayCannotBeNull.class)
  public void deviceTypeGatewayCannotBeNull() {
    new AddDeviceTypeInteractor(null);
  }

  public class InteractorCreated {
    private AddDeviceTypeResponder responder = new AddDeviceTypeResponderSpy();

    @Before
    public void givenAddDeviceTypeInteractor() {
      devTypesSpy = new DeviceTypeGatewaySpy();
      request = new AddDeviceTypeRequest(DEVICE_TYPE_DESCRIPTION, responder);
      addDeviceType = new AddDeviceTypeInteractor(devTypesSpy);
    }

    @Test
    public void gatewayWasNotCalledWhenInteractorNotYetExecuted() {
      assertThat(devTypesSpy.addDeviceTypeWasCalled()).isFalse();
    }

    @Test(expected = AddDeviceTypeInteractor.RequestCannotBeNull.class)
    public void requestCannotBeNull() {
      addDeviceType.execute(null);
    }

    @Test
    public void executeAddOperation() {
      addDeviceType.execute(request);
      assertThat(devTypesSpy.addDeviceTypeWasCalled()).isTrue();
      DeviceType deviceType = devTypesSpy.getDeviceType();
      assertThat(deviceType.getDescription()).isEqualTo(DEVICE_TYPE_DESCRIPTION);
    }

    @Test
    public void callDeviceTypeAlreadyExistsWhenTwoDeviceTypesWithSameDescriptionAdded() {
      addDeviceType.execute(request);
      addDeviceType.execute(request);
      assertThat(((AddDeviceTypeResponderSpy) responder).deviceTypeAlreadyExistsWasCalled())
          .isTrue();
    }
  }
}
