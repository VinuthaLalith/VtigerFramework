package practice;

import org.testng.annotations.Test;

public class DebuggingPractice {
	
	@Test
	public void test() {
		System.out.println("Step1");
		System.out.println("Step2");
		int c=divide(5,0);
		System.out.println(c);
		
	}
	public static int divide(int a,int b) {
		int c=a/b;
		return c;
				
	}
}
