package com.juanba.talkie_toki_api.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // TODO: Base url: http://localhost:8080/swagger-ui/index.html

    @Bean
    public OpenAPI customOpenAPI(@Value("0.0.1") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("TalkIe Toki API")
                        .version(appVersion)
                        .description("""
                                Welcome to the TalkIe Toki Dialogue Platform API! 
                                This project is a REST FULL API that simulates a platform for publishing ideas and fostering dialogue within communities, 
                                allowing users to share and discuss various topics.
                                """))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
