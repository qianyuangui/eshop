package com.ftown.eshop.order.controller;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ftown.eshop.order.feign.CacheSayFeign;
import com.ftown.eshop.order.model.OrderInfo;
import com.ftown.eshop.order.model.UserInfo;
import com.ftown.eshop.order.service.OrderService;
import com.google.gson.JsonObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CacheSayFeign cacheSayFeign;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestParam("orderId") int orderId,
			@RequestParam("descri") String descri,
			@RequestParam("price") double price) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderId(orderId);
		orderInfo.setDescri(descri);
		orderInfo.setPrice(price);
		orderService.addOrder(orderInfo);
		return "success";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(UserInfo info) {
		orderService.addUser(info);
		return "success";
	}
	
	@RequestMapping(value = "/add2", method = RequestMethod.POST)
	public String add2(@RequestParam("hotelId") int hotelId) {
		//启动多线程去调用处理
		for(int i =0;i<10; i++){
			new Thread(new Runnable() {
				public void run() {
					int hotelId = findHotelId();
					System.out.println(hotelId);
					orderService.addRateList(hotelId);
				}
			}).start();
		}
//		ExecutorService executor = Executors.newFixedThreadPool(10);
//		executor.submit(new Runnable() {
//			public void run() {
//				int hotelId = findHotelId();
//				System.out.println(hotelId);
//			}
//		});
//		executor.shutdown();
		return "success";
	}
	
	
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String query(@RequestParam("orderId") int orderId,@RequestParam("start") int start,
			@RequestParam("end") int end) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderId(orderId);
		List<UserInfo> o = orderService.findOrderInfo(orderId,start,end);
		System.out.println(JSON.toJSONString(o));
		return "success";
	}
	
	private AtomicInteger id = new AtomicInteger(50);
	private int findHotelId(){
		return id.getAndIncrement();
	}

	@Autowired
	RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	/**
	 * 1.直接整合hystrix，配置降级的方式（本接口）
	 * 2.整合feign框架，配置降级的方式（say接口）
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/gotoUser",method = RequestMethod.GET)
	@ResponseBody
	@HystrixCommand(fallbackMethod = "getUserDefault")
	public String getUser(@RequestParam String name) {
		String data = restTemplate.getForObject(
				"http://eshop-cache/hello/say1?name=" + name, String.class);
		return data;
	}
	
	public String getUserDefault(String name){
		return "默认数据,"+name;
	}
	
	@RequestMapping(value = "/say",method = RequestMethod.GET)
	public String say(@RequestParam String name){
		System.out.println(""+name);
		String str = cacheSayFeign.say(name);
		return str;
	}
}
