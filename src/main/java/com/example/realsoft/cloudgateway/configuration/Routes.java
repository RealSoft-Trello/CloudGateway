package com.example.realsoft.cloudgateway.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableHystrix
public class Routes {
    private final AuthorizationFilter authorizationHeaderFilter;

    @Bean
    public RouteLocator applicationRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", p-> p.path("/realsoft/trello/auth/**")
                        .uri("lb://user-service"))
                .route("user-service",p -> p.path("/realsoft/trello/users/**")
                        .filters(filter->filter.filter(authorizationHeaderFilter))
                        .uri("lb://user-service"))
                .route("board-service",p -> p.path("/realsoft/trello/boards/**")
                        .filters(filter->filter.filter(authorizationHeaderFilter))
                        .uri("lb://board-service"))
                .route("list-service",p -> p.path("/realsoft/trello/lists/**")
                        .filters(filter->filter.filter(authorizationHeaderFilter))
                        .uri("lb://list-service"))
                .route("comment-service",p -> p.path("/realsoft/trello/comments/**")
                        .filters(filter->filter.filter(authorizationHeaderFilter))
                        .uri("lb://comment-service"))
                .route("card-service",p -> p.path("/realsoft/trello/cards/**")
                        .filters(filter->filter.filter(authorizationHeaderFilter))
                        .uri("lb://card-service"))
                .build();
    }
}
