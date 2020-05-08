package com.ftown.eshop.order.controller;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

	public static void main(String[] args) {
		
		Thread t2 = new Thread(new ThreadB());
		t2.start();
		
		Thread t = new Thread(new ThreadA());
		t.start();
		
	}

}

class ThreadA implements Runnable{
	AtomicInteger i = new AtomicInteger(0);

	private Semaphore semphore = new Semaphore(1);
	@Override
	public void run() {
		try {
			semphore.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true){
			i.getAndIncrement();
			if(i.get() % 2 == 0){
				System.out.println(i);
				semphore.release();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ThreadB implements Runnable{

	private Semaphore semphore = new Semaphore(1);
	AtomicInteger i = new AtomicInteger(0);
	@Override
	public void run() {
		try {
			semphore.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true){
			i.getAndIncrement();
			if(i.get() % 2 == 1){
				System.out.println(i);
				semphore.release();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}