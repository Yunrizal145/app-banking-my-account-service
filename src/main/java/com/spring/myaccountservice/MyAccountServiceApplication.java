package com.spring.myaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAccountServiceApplication.class, args);
	}

}
