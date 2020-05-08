package com.eshop.util;

public class Demo {

	public static void main(String[] args) {

		ClassLoader  loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader);
		
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println("------");
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println("------");
		System.out.println(System.getProperty("java.class.path"));
		
	}

}
