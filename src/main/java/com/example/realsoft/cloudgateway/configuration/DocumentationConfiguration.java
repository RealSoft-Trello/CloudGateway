package com.example.realsoft.cloudgateway.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Primary
public class DocumentationConfiguration implements SwaggerResourcesProvider {
    @Override
    public List get() {
        List<SwaggerResource> resources = new ArrayList();
        resources.add(swaggerResource("card-service", "/cards/swagger", "2.0"));
        resources.add(swaggerResource("serviceHistory-service", "/swagger-ui/", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
