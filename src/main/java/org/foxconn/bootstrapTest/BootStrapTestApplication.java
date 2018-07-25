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
		SpringApplication.run(BootStrapTestApplication.class, args);
		BootStrapServices bootStrapServices = new BootStrapServices();
		List<SystemModel> systems = new ArrayList<SystemModel>();
		String json = bootStrapServices.getJSON("D:\\git\\bootstrapTest\\src\\main\\resources\\7CE829P6TL.json");
		SystemModel system = JSON.parseObject(json, SystemModel.class);
		systems.add(system);
		json = bootStrapServices.getJSON("D:\\git\\bootstrapTest\\src\\main\\resources\\7CE830P1N7.json");
		system = JSON.parseObject(json, SystemModel.class);
		systems.add(system);
		bootStrapServices.writeExcle(systems);
	}
}
	