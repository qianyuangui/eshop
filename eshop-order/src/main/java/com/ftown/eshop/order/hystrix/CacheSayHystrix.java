package com.ftown.eshop.order.hystrix;

import org.springframework.stereotype.Component;

@Component
public class CacheSayHystrix {

	public String say(String name) {
		return "抱歉，服务不可用：" + name;
	}

}
