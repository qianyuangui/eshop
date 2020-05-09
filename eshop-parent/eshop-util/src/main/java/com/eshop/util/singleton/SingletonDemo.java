package com.eshop.util.singleton;

public class SingletonDemo {

	public static void main(String[] args) {

		Thread t = new Thread(new MyThreadB());
		t.start();
		
		Thread t1 = new Thread(new MyThreadC());
		t1.start();
	}

}
class MyThreadB implements Runnable{
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
	}
}

class MyThreadC implements Runnable{
	public void run() {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
	}
}
class Singleton {  
	private Singleton (){}
	byte b = 1;
	short i = 10;
	char c = 0;
	int id = 0;
	float f = 0;
	double d = 0;
	long l = 0;
	boolean bb = true;
	
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();  
    }  
    public static final Singleton getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}