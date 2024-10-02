package ru.meetup.calorie_counter.common.web.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;

@RestController
@ConditionalOnBean(OpenApiProvider.class)
class OpenApiController {

    private static final String GET_CONTRACT_PATH = "/docs/openapi.yaml";

    private final OpenApiProvider openApiProvider;

    public OpenApiController(OpenApiProvider openApiProvider) {
        this.openApiProvider = openApiProvider;
    }

    @CrossOrigin(origins = CorsConfiguration.ALL, methods = {RequestMethod.GET, RequestMethod.HEAD})
    @GetMapping(value = GET_CONTRACT_PATH, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getOpenApiContract() {
        return ResponseEntity.ok(openApiProvider.getPreparedContract());

    }

}
