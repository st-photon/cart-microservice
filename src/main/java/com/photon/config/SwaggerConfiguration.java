package com.photon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

//@SecurityScheme(
//        name = "Authorization",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//)
//@OpenAPIDefinition(
//        info = @Info(title = "ECommerce API", version = "v1"),
//        security = @SecurityRequirement(name = "Authorization")
//)
@Configuration
public class SwaggerConfiguration {

    @Bean
    public MappingJackson2HttpMessageConverter octetStreamJsonConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(new MediaType("application", "octet-stream")));
        return converter;
    }
}
