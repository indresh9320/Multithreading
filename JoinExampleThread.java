package com.multithreading;

public class JoinExampleThread {

	public static void main(String[] args) {
		
		Thread t1=new Thread(() -> {
			System.out.println("Entering Thread t1");
			try {
			Thread.sleep(2000);
			}catch(InterruptedException e)
			{
				throw new IllegalStateException(e);
			}
		});
		
		Thread t2=new Thread(() -> {
			System.out.println("Entering Thread t2");
			try {
			Thread.sleep(2000);
			}catch(InterruptedException e)
			{
				throw new IllegalStateException(e);
			}
		});
		
		System.out.println("Start t1");
		t1.start();
		System.out.println("Waiting t1 to complete");
		try {
			t1.join();
		} catch (InterruptedException e2) {
			throw new IllegalStateException(e2);
		}
		
		System.out.println("Start t2");
		t2.start();
		System.out.println("Waiting t2 to complete");
		try {
			t1.join();
		} catch (InterruptedException e2) {
			throw new IllegalStateException(e2);
		}
		
		
	}
}
