package com.example.departmentservice.config;

import com.example.departmentservice.client.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * WebClientConfig - WebClientConfig class.
 */
@Configuration
public class WebClientConfig {

  /**
   *  LoadBalancedExchangeFilterFunction - LoadBalancedExchangeFilterFunction.
   */
  @Autowired
  private LoadBalancedExchangeFilterFunction filterFunction;

  /**
   *  employeeWebClient - Bean employeeWebClient.
   */
  @Bean
  public WebClient employeeWebClient() {
    return WebClient.builder()
          .baseUrl("http://employee-service")
          .filter(filterFunction)
          .build();
  }

  /**
   *  employeeClient - Bean employeeClient.
   */
  @Bean
  public EmployeeClient employeeClient() {
    HttpServiceProxyFactory httpServiceProxyFactory
          = HttpServiceProxyFactory
          .builder(WebClientAdapter.forClient(employeeWebClient()))
          .build();
    return httpServiceProxyFactory.createClient(EmployeeClient.class);
  }
}
