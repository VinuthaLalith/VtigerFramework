package vtiger.OrganisationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
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

public class CreateOrganisationTests extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createOrgTest() throws IOException {
			 
			//Data from Excel file
			 String ORGNAME = eutil.readDataFromExcel("Organisation", 1, 2)+jutil.getRandomNumber();
			
			//Step3: Click on Organisation
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganisationLink();
			
			//Step4: Click on create org look up image
			Organisationspage op=new Organisationspage(driver);
			op.clickOnOrgLookUpImg();
			
			//Step5: Create organisation with mand fields
			CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
			cnop.createNewOrganisation(ORGNAME);
			
			//Step6: Vlidate
			OrganisationInfoPage oip=new OrganisationInfoPage(driver);
			String OrgHeader=oip.getHeader();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
}
}
