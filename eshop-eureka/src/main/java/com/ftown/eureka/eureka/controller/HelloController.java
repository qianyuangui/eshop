package com.ftown.eureka.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

	@RequestMapping("say")
	public String sayHello(String name){
		return "hello ," + name;
	}
	
}
