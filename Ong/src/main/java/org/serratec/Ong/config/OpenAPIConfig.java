package org.serratec.Ong.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenAPIConfig {
   
    @Bean
    public OpenAPI myOpenAPI(){
       
        Contact contato = new Contact();
        contato.setEmail("joaopedrobr3@gmail.com");
        contato.setName("João Pedro Motta");
        contato.url("https://serratec.org.br");
        
        License apacheLicense = new License()
        .name("Apache licence")
        .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
        .title("API de uma Ong de Adoção")
        .version("1.0")
        .contact(contato)
        .description("Uma API para cadastrar animais para adoção e liga-los a pessoas interessadas em adotar")
        .termsOfService("https://serratec.org.br")
        .license(apacheLicense);

        return new OpenAPI().info(info);
    }

    
    
}
