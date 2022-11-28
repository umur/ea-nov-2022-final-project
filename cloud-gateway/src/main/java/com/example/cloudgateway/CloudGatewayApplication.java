package com.example.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix//circuteBreaker
@EnableCircuitBreaker
@EnableDiscoveryClient
@Configuration
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }

    //this method to go to service discovery and ask for the regitery
    @Bean
//    @ConditionalOnBean(DiscoveryClient.class)
//    @ConditionalOnProperty(name = "spring.cloud.gateway.discovery.locator.enabled")
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(ReactiveDiscoveryClient dc,
                                                                                       DiscoveryLocatorProperties dlp){
        dlp.setLowerCaseServiceId(true);
//        System.out.println(new DiscoveryClientRouteDefinitionLocator(dc, dlp));
        return new DiscoveryClientRouteDefinitionLocator(dc, dlp);
    }

}
