package com.multithreading;

public class First {
	public static void main(String[] args) {
		MyThread mT=new MyThread("indresh");
		mT.start();
		for(int i=0;i<10;i++)
			System.out.println("Print: "+i);
	}
}

class MyThread implements Runnable{
	String my;
	Thread guruthread;
	MyThread(String t)
	{
		this.my=t;
	}
	@Override
	public void run(){
		System.out.println("Thread:"+my);
		try {
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void start() {
		  System.out.println("Thread started");
		  if (guruthread == null) {
			  guruthread = new Thread(this, my);
			  guruthread.start();
		  }
	}
}