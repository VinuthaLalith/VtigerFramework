package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step1: Open the file in java readable foramt
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step2: Cretae object of properties class from java.util
		Properties probj= new Properties();
		
		//Step3: Load the file intom properties
		probj.load(fis);
		
		//Step4: give the key and read the value
		String value=probj.getProperty("browser");
		System.out.println(value);
		
		String value1=probj.getProperty("url");
		System.out.println(value1);
	}

}
