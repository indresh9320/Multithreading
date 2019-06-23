package com.multithreading;

public class RunnableExample {

	public static void main(String[] args) {
		

		System.out.println(Thread.currentThread().getName());
		
		Runnable runnable = ()->{
			System.out.println(Thread.currentThread().getName());
		};
		
		System.out.println("Creating Thread...");
		Thread t= new Thread(runnable);
		
		System.out.println("Starting Thread");
		t.start();
		
	}
	
}
