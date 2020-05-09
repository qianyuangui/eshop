package com.eshop.util.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyUser implements InvocationHandler {
	
	private Object obj;

	public ProxyUser(Object obj){
		this.obj = obj;
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("begin ...");
		method.invoke(obj, args);
		System.out.println("end ...");
		return proxy;
	}


}
