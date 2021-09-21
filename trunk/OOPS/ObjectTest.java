package com.practice.test.interview;

public class ObjectTest {

	private String num;
	public static void main(String[] args) {
		//ObjectTest test = null;
		//test.printMsg();//fine to go, so can call static method but not regular method
		//test.printMsg("Danis");//nullpointer
		ObjectTest tested = new ObjectTest();
		tested.num = "1";
		ObjectTest tested1  = tested;
		tested1.num = "5";
		//tested.printMsg(" param ");
		System.out.println(tested.num + " -- " + tested1.num);
	}
	
	public static void printMsg() {
	//public void printMsg() {//nullPionter
		System.out.println("14: Hello");
		ObjectTest test = null;
		//test.printMsg("from static");//null
	}
	public void printMsg(String name) {
		System.out.println(" 19: Hello "+name);
		ObjectTest test = null;
		test.printMsg();
	}

}
