package client;

import java.io.IOException;
import java.util.LinkedList;

public class Test {
	Person p;
	
	public Test() {
		
		p = new Person();
	}
	
	
	
	public Person getP() {
		return p;
	}



	public static void main(String[] args) throws IOException {
		Test t = new Test();
		LinkedList<String> test;
		test = t.getP().addNickName("Henry", "Tyty");

			System.out.println(test);
		
		
	}
}
