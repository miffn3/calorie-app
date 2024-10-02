package ru.meetup.calorie_counter.common.web.swagger;

import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springdoc.core.configuration.SpringDocUIConfiguration;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Optional;


@Configuration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true")
public class SwaggerUiConfiguration {

    @Bean
    @Primary
    SpringDocConfiguration springDocConfiguration() {
        return new SpringDocConfiguration();
    }

    @Bean
    SpringDocConfigProperties springDocConfigProperties() {
        return new SpringDocConfigProperties();
    }

    @Bean
    ObjectMapperProvider objectMapperProvider(SpringDocConfigProperties springDocConfigProperties) {
        return new ObjectMapperProvider(springDocConfigProperties);
    }

    @Bean
    SpringDocUIConfiguration SpringDocUIConfiguration(
            Optional<SwaggerUiConfigProperties> optionalSwaggerUiConfigProperties) {
        return new SpringDocUIConfiguration(optionalSwaggerUiConfigProperties);
    }

}
