package com.ftown.eshop.usercenter.ha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ftown.eshop.user.mapper")
@EnableFeignClients
@EnableHystrix
@EnableTransactionManagement
public class UserCenterHaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCenterHaApplication.class, args);
	}
}
