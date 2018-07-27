package org.foxconn.bootstrapTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.foxconn.bootstrapTest.entity.SystemModel;
import org.foxconn.bootstrapTest.service.BootStrapServices;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.alibaba.fastjson.JSON;

@SpringBootApplication
@MapperScan("org.foxconn.bootstrapTest.dao")
public class BootStrapTestApplication  extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootStrapTestApplication.class); 
		
	}
	public static void main(String[] args) throws IOException {
//		SpringApplication.run(BootStrapTestApplication.class, args);
		BootStrapServices bootStrapServices = new BootStrapServices();
		List<SystemModel> systemModel = bootStrapServices.getSystemModel();
		bootStrapServices.writeExcle(systemModel);
	}
}
	