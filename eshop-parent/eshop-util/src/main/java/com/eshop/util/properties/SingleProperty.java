package com.eshop.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SingleProperty {
	
	private static Properties prop;

	private static class SinglePropertyHolder {
		private static final SingleProperty singleProperty = new SingleProperty();
	}

	/**
	 * config.properties 内容是 name=kite
	 */
	private SingleProperty() {
		System.out.println("构造函数执行");
		prop = new Properties();
		InputStream stream = SingleProperty.class.getClassLoader()
				.getResourceAsStream("config.properties");
		try {
			prop.load(new InputStreamReader(stream, "utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SingleProperty getInstance() {
		return SinglePropertyHolder.singleProperty;
	}

	public String getName() {
		return prop.get("name").toString();
	}

	public static void main(String[] args) {
		SingleProperty singleProperty = SingleProperty.getInstance();
		System.out.println(singleProperty.getName());
	}
}
