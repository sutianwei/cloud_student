package com.awei.cloud.utils;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {


    /**
     * 这里配置swagger扫描的包
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.awei.cloud"))
                .paths(PathSelectors.any()).build();
    }


    /**
     * 这里配置swagger对外提供服务的端口
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("阿伟专用接口测试")
                .description("人员管理系统接口测试")
                 .termsOfServiceUrl("http://127.0.0.1:8089/doc.html")
                .version("1.0").build();
    }
}
