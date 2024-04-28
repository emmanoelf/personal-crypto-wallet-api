package com.personalcryptowallet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean()
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .info(new Info().title("Personal Crypto Wallet")
                .description("Control your profit or loss with this tool")
                .version("v1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(this.apiContact(new Contact())));
    }

    private Contact apiContact(Contact contact){
        contact.setName("Emmanoel");
        contact.setEmail("emmanoelf.dev@gmail.com");
        contact.setUrl("https://github.com/emmanoelf");

        return contact;
    }
}
