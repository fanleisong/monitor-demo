package com.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@EnableSwagger2
@SpringBootApplication
@MapperScan("com.monitor.mapper")
public class MoniApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoniApplication.class, args);
	}

}
