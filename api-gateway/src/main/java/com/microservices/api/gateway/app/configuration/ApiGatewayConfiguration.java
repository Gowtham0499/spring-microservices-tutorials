package com.microservices.api.gateway.app.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get").filters(f -> f
						.addRequestHeader("Authenticated_UserName", "MyUser")
						.addRequestHeader("Authenticated_Password", "MyPassword"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/forex-api/**")
						.uri("lb://forex-api"))
				.route(p -> p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.build();
	}

}
