package com.snsoft.ElectricHeating;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="com.snsoft.ElectricHeating.mapper")
@SpringBootApplication
public class ElectricHeatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricHeatingApplication.class, args);
	}

}
