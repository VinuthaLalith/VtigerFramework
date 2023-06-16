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

public class CreateOrganisationWithIndustryAndTypeTests extends BaseClass{

	@Test
	public void createOrgWithIndusAndTypeTest() throws IOException {
		
		//Data from Excel file
		 String ORGNAME = eutil.readDataFromExcel("Organisation", 7, 2)+jutil.getRandomNumber();
		 String INDUSTRY = eutil.readDataFromExcel("Organisation",7,3);
		 String TYPE=eutil.readDataFromExcel("Organisation",7,4);
 
		 //Step3: Click on Organisation
		 HomePage hp=new HomePage(driver);
		 hp.clickOnOrganisationLink();

		 //Step4: Click on create org look up image
		 Organisationspage op=new Organisationspage(driver);
		 op.clickOnOrgLookUpImg();

		 //Step5: Create organisation with mand fields
		 CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
		 cnop.createNewOrganisation(ORGNAME, INDUSTRY, TYPE);
		
		 //Step8: Vlidate
		 OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		 String OrgnHeader=oip.getHeader();
		 Assert.assertTrue(OrgnHeader.contains(ORGNAME));
		
	}

}
