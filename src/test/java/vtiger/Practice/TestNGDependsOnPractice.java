package vtiger.Practice;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class TestNGDependsOnPractice {
	
	@Test
	public void create() 
	{
		//Assert.fail();
		System.out.println("created");
		int a=5/0;
	}
	

	@Test(dependsOnMethods = "create")
	public void modify() {
		System.out.println("modified");
	}
	
	@Test
	public void delete() {
		System.out.println("deleted");
	}
	
	
	
	

}
