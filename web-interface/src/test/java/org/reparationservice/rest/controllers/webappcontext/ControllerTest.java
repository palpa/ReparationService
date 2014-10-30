package org.reparationservice.rest.controllers.webappcontext;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.reparationservice.rest.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
//@ContextConfiguration(classes = TestConfig.class)
@WebAppConfiguration
public abstract class ControllerTest {
	@Autowired
	protected WebApplicationContext wac;
	protected MockMvc mockMvc;
	protected final MediaType contentType = new MediaType(
			"application", "hal+json");
	
	private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = null;
	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		for (HttpMessageConverter<?> hmc : Arrays.asList(converters))
			if (hmc instanceof MappingJackson2HttpMessageConverter)
				this.mappingJackson2HttpMessageConverter = (MappingJackson2HttpMessageConverter) hmc;

		Assert.assertNotNull("the JSON message converter must not be null",
				this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(
				o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}
