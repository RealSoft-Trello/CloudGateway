package com.example.realsoft.cloudgateway.configuration;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> openApis = List.of(
            "/register",
            "/login"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApis
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
