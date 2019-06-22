package com.multithreading;

class Printer1{
	public void printDocs(int num,String person)
	{
		for(int i=0;i<num;i++)
		{
			System.out.println("Printing: "+i+" for "+person);
		}
	}
}

class MyNewThread implements Runnable{
	Printer1 p;
	MyNewThread(Printer1 prt)
	{
		p=prt;
	}
	
	@Override
	public void run() {
		p.printDocs(10, "Indresh");
	}
}

class YourNewThread implements Runnable{
	Printer1 p;
	YourNewThread(Printer1 prt)
	{
		p=prt;
	}
	
	@Override
	public void run() {
		p.printDocs(10, "Mohit");
	}
}

public class WithMultithreadingAsync {
	public static void main(String[] args) {
		System.out.println("App Start");
		Printer1 prt=new Printer1();
		MyNewThread t=new MyNewThread(prt);
		YourNewThread t2=new YourNewThread(prt);
		Thread t1=new Thread(t);
		Thread t3=new Thread(t2);
		t1.start();
		t3.start();
		System.out.println("App Finished");
	}
}
