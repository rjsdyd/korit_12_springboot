package com.korit12.cardatabase.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI cardatabaseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Car Database API")
                        .description("자동차 및 소유자 관리를 위한 REST API 명세서")
                        .version("1.0.0")
                );
    }
}
