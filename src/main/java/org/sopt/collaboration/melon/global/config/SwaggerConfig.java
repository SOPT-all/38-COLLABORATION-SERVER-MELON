package org.sopt.collaboration.melon.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                        .title("멜론(Melon) API")
                        .description("LET'S SOPT 합동세미나 iOS 1조 멜론 API")
                        .version("v1")
                );
    }
}
