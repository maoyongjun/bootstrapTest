package org.foxconn.bootstrapTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;

@SpringBootApplication
@MapperScan("org.foxconn.bootstrapTest.dao")
public class BootStrapTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootStrapTestApplication.class, args);
	}
}
