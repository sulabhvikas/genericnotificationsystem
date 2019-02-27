package svik.poc.notify.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          //.apis(RequestHandlerSelectors.any())       
          .apis(RequestHandlerSelectors.basePackage("svik.poc.notify.controllers"))
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Sulabh Vikas", "https://github.com/sulabhvikas", "vikas.sulabh@gmail.com");
        return new ApiInfoBuilder()
                .title("Generic Notification System")
                .description("Generic Notification System to channelize notifications from authorized apps to multiple channels")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

}
