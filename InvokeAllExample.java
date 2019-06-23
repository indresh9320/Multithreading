package com.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Submit multiple tasks and wait for all of them to complete.
		//You can execute multiple tasks by passing a collection of Callables 
		//to the invokeAll() method. The invokeAll() returns a list of
		//Futures. Any call to future.get() will block until all the Futures 
		//are complete.
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Callable<String> task1 = () -> {
            //Thread.sleep(200);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {
            //Thread.sleep(100);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {
            //Thread.sleep(500);
            return "Result of Task3";
        };
        
        List<Callable<String>> taskList = Arrays.asList(task1, task2, task3);

        List<Future<String>> futures = executorService.invokeAll(taskList);

        for(Future<String> future: futures) {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            System.out.println(future.get());
        }

        executorService.shutdown();
	}

}
