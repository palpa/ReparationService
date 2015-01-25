package org.reparationservice.datanucleus;

import org.junit.Test;
import org.reparationservice.entities.Configurator;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfiguratorTest {
	@Test
	public void instance() throws Exception {
		Configurator instance = DatanucleusConfigurator.instance;
		assertThat(instance).isNotNull();
		assertThat(instance).isInstanceOf(DatanucleusConfigurator.class);
	}
}
