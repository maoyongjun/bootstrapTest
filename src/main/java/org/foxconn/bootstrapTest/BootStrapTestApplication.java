package org.foxconn.bootstrapTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("org.foxconn.bootstrapTest.dao")
public class BootStrapTestApplication  extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootStrapTestApplication.class); 
		
	}
	public static void main(String[] args) {
		SpringApplication.run(BootStrapTestApplication.class, args);
	}
}
	