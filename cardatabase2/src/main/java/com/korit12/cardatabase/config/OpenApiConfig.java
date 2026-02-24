package com.korit12.cardatabase.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration          // 빈 정의를 제공하는 소스 클래스라는 것을 명시
public class OpenApiConfig {
    @Bean                       // 메서드 리턴 객체를 Spring 빈으로 등록
    public OpenAPI cardatabaseOpenAPI() {
        // 직접 OpenAPI 객체를 생성하고 커스터마이징(빌더패턴을 통해) 함.
        return new OpenAPI()
                .info(new Info()
                        .title("Car Database API")
                        .description("자동차 및 소유자 관리를 위한 REST API 명세서")
                        .version("1.0.0")
                );
    }
}
