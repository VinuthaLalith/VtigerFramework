package vtiger.Practice;

import java.io.IOException;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility proUtil=new PropertyFileUtility();
		String value=proUtil.readDataFromPropertyFile("url");
	    System.out.println(value);
	    
	    ExcelUtility eUtil=new ExcelUtility();
	    String data=eUtil.readDataFromExcel("Organisation", 1, 2);
	    System.out.println(data);
	    
	   // eUtil.writeDataIntoExcel("Trial", 3, 4, "JacjJill");
	   // System.out.println("Data added");
	    
	    JavaUtility jutil=new JavaUtility();
	    System.out.println(jutil.getSystemDate());
	    System.out.println(jutil.getRandomNumber());
	    System.out.println(jutil.getSystemDateInFormat());
	}

}
