package com.multithreading;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyExaple {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Submit multiple tasks and wait for any one of them to complete
		//The invokeAny() method accepts a collection of Callables and 
		//returns the result of the fastest Callable. Note that, it does 
		//not return a Future.
		
		ExecutorService executor=Executors.newScheduledThreadPool(5);
		
		Callable<String> task1 = () -> {
            Thread.sleep(200);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(100);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            //Thread.sleep(500);
            return "Result of Task3";
        };
        
        String result = executor.invokeAny(Arrays.asList(task1,task2,task3));
        
        System.out.println(result);
        
        executor.shutdown();
	}

}
