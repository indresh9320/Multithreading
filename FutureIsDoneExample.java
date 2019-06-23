package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureIsDoneExample {
	public static void main(String[] args) {
		
		ExecutorService exec=Executors.newSingleThreadExecutor();
		
		Future<String> ftr=exec.submit(()->{
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "In Future";
		});
		
		while(!ftr.isDone()) {
			System.out.println("Task is in process");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Task Completed");
		try {
			String result=ftr.get();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		exec.shutdown();
	}
}
