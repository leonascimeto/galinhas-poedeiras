package tech.leondev.wakandagalinheiro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("REST API - Galinheiro WAKANDA")
                                .description("API para gestão de galinhas poedeiras")
                                .version("v1")
                                .contact(new Contact().name("Leo Nascimento").email("nascimentoleo899@gmail.com"))
                );
    }
}
