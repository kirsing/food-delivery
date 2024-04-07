package com.example.kirsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class EdgeserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EdgeserverApplication.class, args);
    }

    @Bean
    public RouteLocator foodDeliveryRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/services/restaurants/**")
                        .filters(f -> f.rewritePath("/services/restaurants/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://RESTAURANTS"))
                .route(p -> p
                        .path("/services/foodcatalogue/**")
                        .filters(f -> f.rewritePath("/services/foodcatalogue/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://FOODCATALOGUE"))
                .route(p -> p
                        .path("/services/orders/**")
                        .filters(f -> f.rewritePath("/services/orders/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://ORDERS"))
                .route(p -> p
                        .path("/services/userinfo/**")
                        .filters(f -> f.rewritePath("/services/userinfo/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://USERINFO"))
                .build();
    }


}
