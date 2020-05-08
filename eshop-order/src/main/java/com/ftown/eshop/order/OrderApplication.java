package com.ftown.eshop.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ftown.eshop.order.mapper")
@EnableFeignClients
@EnableHystrix
@EnableTransactionManagement
public class OrderApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrderApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(
				streamServlet);
		registrationBean.setLoadOnStartup(1); // 系统启动时加载顺序
		registrationBean.addUrlMappings("/actuator/hystrix.stream");// 路径
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

	@Bean
	public IRule ribbonRule() {
		return new RandomRule(); // 这里配置策略，和配置文件对应
	}

}
