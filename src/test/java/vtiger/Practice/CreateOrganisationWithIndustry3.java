package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationInfoPage;
import objectRepository.Organisationspage;

public class CreateOrganisationWithIndustry3 {

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
		 
		//Data from Excel file
		 String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2)+jutil.getRandomNumber();
		 String INDUSTRY = eutil.readDataFromExcel("Organisation",4,3);
		 
		//Step1: launch the browser
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
		 
		 wutil.maximizeWindow(driver);
		 wutil.waitForPageLoad(driver);
		 driver.get(URL);
		
		//Step2: Login to application
		LoginPage lp=new LoginPage(driver);
		lp.LogintoApp(USERNAME, PASSWORD);
		
		//Step3: Click on Organisation
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		//Step4: Click on create org look up image
		Organisationspage op=new Organisationspage(driver);
		op.clickOnOrgLookUpImg();
		
		//Step5: Create organisation with mand fields
		CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		cnop.createNewOrganisation(ORGNAME, INDUSTRY);
		
		//Step8: Vlidate
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String OrgHeader=oip.getHeader();
		
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("Organisation Created");
		}
			else
			{
				System.out.println("FAIL");
			}
		
		//Step9: Logout of App
		hp.logOutOfApp(driver);
		System.out.println("Logout is successful");
		driver.quit();
	}

}
