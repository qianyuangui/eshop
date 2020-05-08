package com.ftown.eshop.eureka.ha.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaHaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaHaaApplication.class, args);
	}
}
