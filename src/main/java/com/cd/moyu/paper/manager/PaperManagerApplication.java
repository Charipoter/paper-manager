package com.cd.moyu.paper.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cd.moyu.paper.manager.mapper")
@SpringBootApplication
public class PaperManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperManagerApplication.class, args);
	}

}
