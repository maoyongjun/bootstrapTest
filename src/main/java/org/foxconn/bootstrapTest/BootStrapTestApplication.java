package org.foxconn.bootstrapTest;

import java.io.IOException;

import javax.annotation.Resource;

import org.foxconn.bootstrapTest.service.BootStrapServices;
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
		BootStrapServices bootStrapServices = new BootStrapServices();
		bootStrapServices.writeExcle();
		try {
			bootStrapServices.getJSON() ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	