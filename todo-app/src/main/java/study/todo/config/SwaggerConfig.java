package study.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // swagger documentation 생성을 위한 bean 객체 생성
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("todo-api")
                .select()
                // 현재 RequestMapping으로 할당된 url 리스트
                .apis(RequestHandlerSelectors.basePackage("study.todo.web.controller"))
                .paths(PathSelectors.any())

                .build()
                .apiInfo(apiInfo());
    }

    // api documentaton 정보 설정
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API for ToDo App")
                .description("REST API for ToDo App")
                .termsOfServiceUrl("")
                .contact("gloria")
                .license("License of API")
                .licenseUrl("License of URL")
                .version("1.0")
                .build();
    }

}
