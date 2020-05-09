package com.eshop.util.dynamic;

import java.lang.reflect.Proxy;

public class DynamicDemo {

	public static void main(String[] args) {

		//VM参数
		//-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
		IUser user = (IUser) Proxy.newProxyInstance(IUser.class.getClassLoader(), 
				new Class[]{IUser.class,IPerson.class}, new ProxyUser(new UserImpl()));
		
		user.say();
	}

}
