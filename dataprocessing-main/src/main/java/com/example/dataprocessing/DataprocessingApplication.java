package com.example.dataprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class DataprocessingApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataprocessingApplication.class, args);
    }
    @Bean
    public Docket swaggerConfiguration()
    {
        //return an prepared docket
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.example.dataprocessing"))
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Pokemon REST API",
                "An API that is connected to a pokemon database with 3 tables.",
                "v1.0",
                "",
                new Contact("Tom Olijve", "https://www.linkedin.com/in/tom-olijve-b23815208/", "tom.olijve@student.nhlstenden.com"),
                "This is a mandatory", "https://www.youtube.com/watch?v=0lhhrUuw2N8&ab_channel=GamingSoundFX", Collections.emptyList());
    }

}
