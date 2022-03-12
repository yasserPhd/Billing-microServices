package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
/* @EnableHystrix */
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}
	
	
	
	
	
	
	
	
	
	  @Bean
	  public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator( ReactiveDiscoveryClient rd,
	  DiscoveryLocatorProperties dlp) { return new
	  DiscoveryClientRouteDefinitionLocator(rd, dlp); }
	
	  @Bean
		RouteLocator staticRoutes(RouteLocatorBuilder builder){
		
			return builder.routes()
					
					  .route(r->r .path("/meteo/**") .
							  filters(f->f
							  .addRequestHeader("x-rapidapi-host",
							  "community-open-weather-map.p.rapidapi.com")
							  .addRequestHeader("x-rapidapi-key",
							  "7c0721e21emshdfe0674468b70d2p10fb60jsn9e53c827b4d5")
							  .rewritePath("/meteo/(?<segment>.*)","/${segment}")
							  //.circuitBreaker(h->h.setName("me-teo").setFallbackUri("forward:/defaultMeteo"))
							
							  ) .uri("https://community-open-weather-map.p.rapidapi.com"))
					  
					  .route(r->r .path("/price/**") .
							  filters(f->f
							  .addRequestHeader("x-rapidapi-host",
							  "magic-aliexpress1.p.rapidapi.com")
							  .addRequestHeader("x-rapidapi-key",
							  "7c0721e21emshdfe0674468b70d2p10fb60jsn9e53c827b4d5")
							  .rewritePath("/price/(?<segment>.*)","/${segment}")
							  
							  ) .uri("https://magic-aliexpress1.p.rapidapi.com"))
					  
					  .build();
		}
	  
		/*
		 * "https://community-open-weather-map.p.rapidapi.com/weather"
		 */	 
	 
	  
		
		/*
		 * .route(r->r .path("/weather/**") .filters(f->f
		 * .addRequestHeader("x-rapidapi-host",
		 * "community-open-weather-map.p.rapidapi.com")
		 * .addRequestHeader("x-rapidapi-key",
		 * "7c0721e21emshdfe0674468b70d2p10fb60jsn9e53c827b4d5")
		 * .rewritePath("/weather/(?<segment>.*)","/${segment}")
		 * 
		 * ) .uri("https://community-open-weather-map.p.rapidapi.com/weather"))
		 */
		  
		  
		  
		 
			/*
			 * .route( r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
			 * 
			 * .route( r -> r.path("/customers/**").uri("http://localhost:8082"))
			 */

}
