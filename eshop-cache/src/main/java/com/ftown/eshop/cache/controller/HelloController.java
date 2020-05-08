package com.ftown.eshop.cache.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

	@RequestMapping(value = "/say1",method = RequestMethod.GET)
	public String say1(@RequestParam String name){
		System.out.println("hello," + name);
		return "hello ," + name;
	}
	
	@RequestMapping(value = "/say",method = RequestMethod.POST)
	public String say(@RequestParam String name){
		System.out.println("hello," + name);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello ," + name;
	}
	
}
