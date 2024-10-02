package ru.meetup.calorie_counter.common.web.swagger;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@Getter
@Component
@ConditionalOnProperty(value = "springdoc.swagger-ui.enabled", havingValue = "true")
class OpenApiProvider {

    private static final String OPEN_API_CLASSPATH = "classpath:openapi/calorie-counter-docs.yaml";

    private final String preparedContract;

    public OpenApiProvider(@Value(OPEN_API_CLASSPATH) Resource openApiContractResource)
            throws IOException {
        preparedContract = new String(openApiContractResource.getInputStream().readAllBytes(), UTF_8);
    }

}
