package com.todolist.tododb.config;

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
                        .title("Todo Database API")
                        .description("할 일 관리를 위한 REST API 명세서")
                        .version("1.0.0")
                );
    }
}

