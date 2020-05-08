package com.ftown.eshop.order.feign.fallback;

import org.springframework.stereotype.Component;

import com.ftown.eshop.order.feign.CacheSayFeign;

import feign.hystrix.FallbackFactory;

@Component
public class CacheSayFeignFallback implements FallbackFactory<CacheSayFeign> {

	public CacheSayFeign create(Throwable arg0) {
		return new CacheSayFeign() {
			public String say(String name) {
				return "Feign fallback," + name;
			}
		};
	}
}
