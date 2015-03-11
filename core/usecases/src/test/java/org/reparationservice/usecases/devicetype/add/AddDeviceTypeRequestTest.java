package org.reparationservice.usecases.devicetype.add;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(HierarchicalContextRunner.class)
public class AddDeviceTypeRequestTest {
  private static final String DESCRIPTION = "any description";

  @Test(expected = AddDeviceTypeRequest.ResponderCannotBeNull.class)
  public void testResponderCannotBeNull() throws Exception {
    new AddDeviceTypeRequest(DESCRIPTION, null);
  }

  public class RequestCreated {
    private AddDeviceTypeResponder responder;
    private AddDeviceTypeRequest request;

    @Before public void givenRequest() {
      responder = new AddDeviceTypeResponderSpy();
      request = new AddDeviceTypeRequest(DESCRIPTION, responder);
    }

    @Test
    public void testGetDescription() throws Exception {
      assertThat(request.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    public void testRequestAsResponder() throws Exception {
      AddDeviceTypeResponder requestAsResponder = request;
      requestAsResponder.deviceTypeAlreadyExists();

      assertThat(((AddDeviceTypeResponderSpy) responder).deviceTypeAlreadyExistsWasCalled())
          .isTrue();
    }
  }
}
