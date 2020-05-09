package com.eshop.util.dynamic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class JdkProxySourceClass {
	public static void writeClassToDisk(String path){
		 
		byte[] classFile = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{IUser.class});
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			fos.write(classFile);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
 
    public void testGenerateProxyClass() {  
    	JdkProxySourceClass.writeClassToDisk("D:/$Proxy0.class");  
    }
}
