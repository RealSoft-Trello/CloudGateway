package com.example.realsoft.cloudgateway;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;

@Component
public class OneApiResource extends JsonSerializer<Json> {
    @Override
    public void serialize(Json json, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

    }
}
