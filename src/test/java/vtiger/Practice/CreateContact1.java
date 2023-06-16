package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v109.accessibility.model.AXRelatedNode;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ConatctInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContact1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//Create objects of all the uitilities
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelUtility eutil=new ExcelUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		
		WebDriver driver=null;
		
		//Read all the required data
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		 String USERNAME = putil.readDataFromPropertyFile("username");
		 String PASSWORD=putil.readDataFromPropertyFile("password");
		
	   // String FIRSTNAME=eutil.readDataFromExcel("Contact", 1, 2);
		String LASTNAME =eutil.readDataFromExcel("Contact", 1, 3);   	
		
		//Launch the browser
		 if(BROWSER.equalsIgnoreCase("chrome")){
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			System.out.println(BROWSER+"---launched"); 	
		 }
		 else if(BROWSER.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 System.out.println(BROWSER+"---launched"); 	
		 }
		 else {
			 System.out.println("Invalid Browser name");
		 }
		 wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step2: Login to application
				LoginPage lp=new LoginPage(driver);
				lp.LogintoApp(USERNAME, PASSWORD);
		
		//Click On Contacts link and create new contact
		HomePage hp=new HomePage(driver);
		hp.clicknContactsLink();
		
		//Click on Contacts lookup image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactsLookImg();
		
		//Create conatct with mandatory fields
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//Validate
		ConatctInfoPage cip=new ConatctInfoPage(driver);
		String ContactHeader=cip.getContactHeader();
		if(ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("Contact created");
		} else {
			System.out.println("FAIL");
		}
		
		//SignOut
		hp.logOutOfApp(driver);
		
		driver.quit();
		
		
	
		

	}

}
