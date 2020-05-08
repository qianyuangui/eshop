package com.ftown.eshop.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftown.eshop.order.feign.fallback.CacheSayFeignFallback;

@FeignClient(name = "eshop-cache",path = "/hello",fallbackFactory = CacheSayFeignFallback.class)
public interface CacheSayFeign {

	@RequestMapping(value = "/say",method = RequestMethod.GET)
	public String say(@RequestParam("name") String name);
}
