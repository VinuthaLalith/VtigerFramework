package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This class consists of all the basic configuration annotations of testNG
 * @author vinuv
 *
 */
public class BaseClass {
	
	//Create objects of all the uitilities
		public JavaUtility jutil=new JavaUtility();
		public PropertyFileUtility putil=new PropertyFileUtility();
		public ExcelUtility eutil=new ExcelUtility();
		public WebDriverUtility wutil=new WebDriverUtility();
		
		public WebDriver driver=null;
		public static WebDriver sDriver;
		
		@BeforeSuite(groups = {"SmokeSuite", "RegressionSuite"})
		public void bsConfig() {
			System.out.println("=======Database Connection Successful========");
		}
		
		//@Parameters("browser")
		//@BeforeTest
		@BeforeClass(alwaysRun = true)
		public void bcConfig(/*String BROWSER*/) throws IOException {
			
			String BROWSER=putil.readDataFromPropertyFile("browser");
			String URL=putil.readDataFromPropertyFile("url");
			
			//launch the browser
			 if(BROWSER.equalsIgnoreCase("chrome")) {

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
		 
			 sDriver=driver;
		 wutil.maximizeWindow(driver);
		 wutil.waitForPageLoad(driver);
		 driver.get(URL);
		}
	
		
		@BeforeMethod(alwaysRun = true)
		public void bmConfig() throws IOException {
			
			String USERNAME=putil.readDataFromPropertyFile("username");
			String PASSWORD=putil.readDataFromPropertyFile("password");
			
			LoginPage lp=new LoginPage(driver);
			lp.LogintoApp(USERNAME, PASSWORD);
			
			System.out.println("=======Login is Successful========");
		}
		
		@AfterMethod(alwaysRun = true)
		public void amConfig() {
			
			HomePage hp=new HomePage(driver);
			hp.logOutOfApp(driver);
			
			System.out.println("=======Logout is Successful========");
		}
		
		//@AfterTest
		@AfterClass(alwaysRun = true)
		public void acConfig() {
			
			driver.quit();
			System.out.println("=======Browser Closed========");
		}
		
		@AfterSuite(alwaysRun = true)
		public void asConfig() {
			
			System.out.println("=======Database Connection Successful========");
		}

}
