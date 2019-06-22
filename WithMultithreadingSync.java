package com.multithreading;

class Printer12{
	//synchronized public void printDocs(int num,String person) //synchronized method=> intrinsic lock is acquired on the method by the thread so other thread will not be able to access the method 
	public void printDocs(int num,String person)
	{
		for(int i=0;i<num;i++)
		{
			System.out.println("Printing: "+i+" for "+person);
		}
	}
}

class MyNewThread1 implements Runnable{
	Printer12 p;
	MyNewThread1(Printer12 prt)
	{
		p=prt;
	}
	
	@Override
	public void run() {
		synchronized(p) {			//synchronized block
		p.printDocs(10, "Indresh");
		}
	}
}

class YourNewThread1 implements Runnable{
	Printer12 p;
	YourNewThread1(Printer12 prt)
	{
		p=prt;
	}
	
	@Override
	public void run() {
		synchronized(p) {				//synchronized block
		p.printDocs(10, "Mohit");
		}
	}
}

public class WithMultithreadingSync {
	public static void main(String[] args) {
		System.out.println("App Start");
		Printer12 prt=new Printer12();
		MyNewThread1 t=new MyNewThread1(prt);
		YourNewThread1 t2=new YourNewThread1(prt);
		Thread t1=new Thread(t);
		Thread t3=new Thread(t2);
		t1.start();
		t3.start();
		System.out.println("App Finished");
	}
}
