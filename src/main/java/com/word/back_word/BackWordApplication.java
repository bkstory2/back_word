package com.word.back_word;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("mapper")
public class BackWordApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackWordApplication.class, args);
	}

}

