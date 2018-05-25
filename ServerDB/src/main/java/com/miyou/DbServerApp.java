package com.miyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DbServerApp {

	public static void main(String[] args) {
		SpringApplication.run(DbServerApp.class, args);
	}

}
