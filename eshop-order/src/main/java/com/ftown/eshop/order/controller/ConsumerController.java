package com.ftown.eshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftown.eshop.order.feign.UserCenterFeignClientInterface;

@RestController
public class ConsumerController {

	@Autowired
	UserCenterFeignClientInterface feignService;

	@RequestMapping("/hello")
	public String helloConsumer(@RequestParam("name")String str) {
		return feignService.hello(str);
	}

}
