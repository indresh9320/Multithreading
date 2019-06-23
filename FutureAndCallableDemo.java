package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableDemo {

	public static void main(String[] args) {
		
		ExecutorService exec=Executors.newScheduledThreadPool(2);
		
		Callable<String> callable=() -> {
			System.out.println("Entered Callable");
			return "Hello from Callable";
		};
		
		Future<String> ftr=exec.submit(callable);
		try {
			String result=ftr.get(); //result will get the result returned from callable
			System.out.println("Future Get: "+result); 
		} catch (Exception e) {
		}
		exec.shutdown();  //This is required to shutdown the ExecutorService when the treadexecution is completed
	}
}
