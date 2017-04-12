package com.study.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Configuration
@EnableSwagger2
public class ToDoApplication {

    private static final Logger logger = LoggerFactory.getLogger(ToDoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
        logger.debug("Spring boot ToDoApplication Start~!!");
    }

    // swagger documentation 생성을 위한 bean 객체 생성
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 현재 RequestMapping으로 할당된 url 리스트
                .apis(RequestHandlerSelectors.basePackage("com.study.todo.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    // api documentaton 정보 설정
    private ApiInfo apiInfo() {
        Contact contact = new Contact("gloria",
                                        "https://gloriajun.github.io",
                                        "pureainu@gmail.com");

        ApiInfo apiInfo = new ApiInfo(
                "REST API for ToDo App",
                "REST API for ToDo App",
                "API TOS",
                "Terms of service",
                "gloria",
                "License of API",
                "API license URL");
        return apiInfo;
    }
}
