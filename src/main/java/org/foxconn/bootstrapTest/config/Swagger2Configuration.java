package org.foxconn.bootstrapTest.config;


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
public class Swagger2Configuration //extends WebMvcConfigurerAdapter
{
	public Docket buildDocket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(buildApiInf())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.foxconn.bootstrapTest.service"))
				.paths(PathSelectors.any())
				.build();
	}
	private ApiInfo buildApiInf(){
		return new ApiInfoBuilder()
				.title("swagger Test")
				.description("测试swagger")
				.termsOfServiceUrl("localhost")
				.contact(new Contact("justin", "localhost", "123@foxconn.com"))
				.build();
	}
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
////		registry.addResourceHandler("/swagger-ui.html")
////		.addResourceLocations("classpath:/META-INF/resources/");
//		
//		registry.addResourceHandler("/webjars/**")
//		.addResourceLocations("classpath:/META-INF/resources/webjars/*");
//		
//	}
}
