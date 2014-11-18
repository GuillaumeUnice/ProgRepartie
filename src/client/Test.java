package client;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class Test {
	static Person p;
	
	public Test() {
		
		p = new Person();
	}
	
	  public static String getMethodeName()
	  {
	          Throwable t = new Throwable();
	          t.fillInStackTrace();
	          StackTraceElement e = t.getStackTrace()[1];
	          String functionName = e.getMethodName();
	          return functionName ;
	  }
	
	public Person getP() {
		return p;
	}



	public static void main(String[] args) throws IOException {
		Test t = new Test();
		/*LinkedList<String> test;
		test = t.getP().addNickName("Henry", "Tyty");
		
			System.out.println(test);*//*
		Method[] res = t.getP().getClass().getDeclaredMethods() ; 
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i].getName());
		}*/
		t.getP().printFunction();
	
	}
}
