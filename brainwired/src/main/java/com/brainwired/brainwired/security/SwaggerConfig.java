package com.brainwired.brainwired.security;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server()
                .url("http://localhost:8080")
                .description("Local environment");

        Contact contact = new Contact()
                .name("API Support")
                .email("[email protected]");

        Info info = new Info()
                .title("Spring Boot API Documentation")
                .version("1.0")
                .description("API documentation for Spring Boot project")
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
