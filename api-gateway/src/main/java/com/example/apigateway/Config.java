package com.example.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.netty.http.client.HttpClient;

@Configuration
public class Config {

    /*
    spring.cloud.gateway.routes[0].id=test
spring.cloud.gateway.routes[0].uri=lb://eureka-client-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/main/test
spring.cloud.gateway.routes[0].predicates[1]=Method=GET

spring.cloud.gateway.routes[1].id=test2
spring.cloud.gateway.routes[1].uri=lb://eureka-client-service-2
spring.cloud.gateway.routes[1].predicates[0]=Path=/hello
spring.cloud.gateway.routes[1].predicates[1]=Method=GET
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/main/test").and()
                        .method(HttpMethod.GET)
                        .uri("lb://eureka-client-service")
                )
                .route(p -> p
                        .path("/hello").and()
                        .method(HttpMethod.GET)
                        .uri("lb://eureka-client-service-2")
                )
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
//                .route(p -> p
//                        .host("*.circuitbreaker.com")
//                        .filters(f -> f.circuitBreaker(config -> config
//                                .setName("mycmd")
//                                .setFallbackUri("forward:/fallback")))
//                        .uri("http://httpbin.org:80"))
                .build();
    }

}
