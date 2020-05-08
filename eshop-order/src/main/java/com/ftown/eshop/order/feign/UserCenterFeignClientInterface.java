package com.ftown.eshop.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient( value = "eshop-usercenter" )
public interface UserCenterFeignClientInterface {

	@GetMapping("/hello")
    String hello( @RequestParam("name") String param );
}
