package com.multithreading;

class Printer{
	public void printDocs(int num,String person)
	{
		for(int i=0;i<num;i++)
		{
			System.out.println("Printing: "+i+" for "+person);
		}
	}
}

public class WithoutMultithreading {

	public static void main(String[] args) {
		System.out.println("App Start");
		Printer prt=new Printer();
		prt.printDocs(10, "Indresh");
		System.out.println("App Finished");
	}
}
