package br.com.luminaapps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableWebMvc
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"br.com.luminaapps"})
public class SwaggerConfig {

    private final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

    @Value("${swagger.api-name}")
    private String name;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;


    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

    @Bean
    public Docket api() {
        logger.info("Startando Swagger");
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfo(
                name,
                description,
                version,
                "",
                new Contact("Gustavo Reis", "www.luminaapps.com", "gustavohdosreis@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
