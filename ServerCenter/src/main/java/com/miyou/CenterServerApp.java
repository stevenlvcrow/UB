package com.miyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CenterServerApp {

	public static void main(String[] args) {
		SpringApplication.run(CenterServerApp.class, args);
	}
}
