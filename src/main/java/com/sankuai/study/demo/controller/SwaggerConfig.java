package com.sankuai.study.demo.controller;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2    //开启Swagger
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sankuai.study.demo.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("张三的世界", "http://localhost:8080", "kuangtuzhangsan@qq.com");
        return new ApiInfo(
                "张三的Swagger文档",    //名字
                "今天的我做了什么",  //座右铭
                "1.0",                 //版本号
                "http://localhost:8080",//作者连接
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

}

