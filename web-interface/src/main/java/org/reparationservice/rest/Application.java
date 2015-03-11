package org.reparationservice.rest;

import org.reparationservice.entities.worker.WorkerGateway;
import org.reparationservice.inmemory.InMemoryConfigurator;
import org.reparationservice.requestor.InteractorFactory;
import org.reparationservice.requestor.RequestBuilder;
import org.reparationservice.requestor.UseCaseActivator;
import org.reparationservice.requestor.impl.InteractorFactoryImpl;
import org.reparationservice.requestor.impl.RequestBuilderImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean WorkerGateway getWorkerGW() {
    return InMemoryConfigurator.getWorkerGateway();
  }

  @Bean InteractorFactory getInteractorFactory() {
    return new InteractorFactoryImpl();
  }

  @Bean RequestBuilder getRequestBuilder() {
    return new RequestBuilderImpl();
  }

  @Bean @Qualifier("AddWorkerInteractor") UseCaseActivator getAddWorkerInteractor() {
    return getInteractorFactory().makeAddWorkerInteractor(getWorkerGW());
  }

  @Bean @Qualifier("GetAllWorkersInteractor") UseCaseActivator getGetAllWorkersInteractor() {
    return getInteractorFactory().makeGetAllWorkersInteractor(getWorkerGW());
  }

  @Configuration
  public static class DisableStaticResourceConfiguration extends WebMvcAutoConfigurationAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
  }
}
