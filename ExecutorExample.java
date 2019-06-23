package com.multithreading;

import java.util.concurrent.*;

public class ExecutorExample {

	public static void main(String[] args) {
		
ExecutorService executor=(ExecutorService) Executors.newFixedThreadPool(2);
		
		Runnable task1=()->{
			System.out.println("Task 1 Running:"+Thread.currentThread().getName());
			System.out.println(executor.isShutdown());
			try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
		};
		Runnable task2=()->{
			System.out.println("Task 2 Running:"+Thread.currentThread().getName());
			System.out.println(executor.isShutdown());
			try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
		};
		Runnable task3=()->{
			System.out.println("Task 3 Running:"+Thread.currentThread().getName());
			System.out.println(executor.isShutdown());
			try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
		};
		
		executor.submit(task1);
		executor.submit(task2);
		executor.submit(task3);

		executor.shutdown();
		System.out.println(executor.isShutdown());
	}

}
