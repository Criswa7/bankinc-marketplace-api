package com.bankinc.marketplace.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080");
        devServer.setDescription("Development server");

        Contact contact = new Contact();
        contact.setName("Bank Inc Team");
        contact.setEmail("support@bankinc.com");

        Info info = new Info()
                .title("Bank Inc Marketplace API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints for the Bank Inc Marketplace.")
                .termsOfService("http://bankinc.com/terms");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer));
    }
}