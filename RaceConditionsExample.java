package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ABC {
	int counter=0;

	public int getCounter() {
		return counter;
	}

	public void setCounter() {
		synchronized (this){
		this.counter = counter+1;
		}
	}
	
}

public class RaceConditionsExample {

	public static void main(String[] args) {
		
		ExecutorService exec=Executors.newScheduledThreadPool(5);
		ABC abc=new ABC();
		for(int i=0;i<100;i++)
		{
			exec.submit(()->abc.setCounter());
		}

		exec.shutdown();
		System.out.println(abc.getCounter());
	}

}
