package springboot.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2Config {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("spring-boot-test 的接口文档")
                        .description("用于接口的描述")
//                        .contact(new Contact("MrXu", "https://github.com/mrxu0", "645352780@qq.com"))
                        .contact(new Contact("MrXu", null, null))
                        .version("1.0版本")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("springboot.demo.test.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
