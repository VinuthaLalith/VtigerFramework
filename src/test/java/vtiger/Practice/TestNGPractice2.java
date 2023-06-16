package vtiger.Practice;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class TestNGPractice2 {
	
	@Test(invocationCount = 0)   
	public void create() {
	
		System.out.println("create");
	}
		
	@Test(priority = 1, invocationCount=3)
	public void modify() {
		
		System.out.println("modify");

}
	@Test(priority = 2, enabled=false)
	public void delete() {
		
		System.out.println("delete");
		
	}
}
	
