package com.ftown.eshop.order.controller;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {

	public static void main(String[] args) {

		Thread a = new Thread(new Thread1());
		a.start();
		Thread b = new Thread(new Thread2());
		b.start();
	}

}

class Thread1 implements Runnable {
	AtomicInteger i = new AtomicInteger(1);

	@Override
	public void run() {
		synchronized (Demo2.class) {
			while (true) {
				if (i.get() % 2 == 1) {
					System.out.println(i.get());
				}
				i.getAndIncrement();
				Demo2.class.notify();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Demo2.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class Thread2 implements Runnable {

	AtomicInteger i = new AtomicInteger(2);

	@Override
	public void run() {
		synchronized (Demo2.class) {
			while (true) {
				if (i.get() % 2 == 0) {
					System.out.println(i.get());
				}
				i.getAndIncrement();
				Demo2.class.notify();
				try {
					Demo2.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}