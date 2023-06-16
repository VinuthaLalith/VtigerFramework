package vtiger.OrganisationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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

@Listeners(genericUtilities.ListenersImplimentation.class)
public class CreateOrganisationWithIndustryTests extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createOrgWithIndusTest() throws IOException {
				 
				//From Excel file
				 String ORGNAME = eutil.readDataFromExcel("Organisation", 4, 2)+jutil.getRandomNumber();
				 String INDUSTRY = eutil.readDataFromExcel("Organisation",4,3);
				 	
				//Step3: Click on Organisation
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganisationLink();
				Reporter.log("Clicked on Organisation link",true);
				
				//Step4: Click on create org look up image
				Organisationspage op=new Organisationspage(driver);
				op.clickOnOrgLookUpImg();
				Reporter.log("Clicked on Org Look Up image",true);
				
				Assert.fail();
				//Step5: Create organisation with mand fields
				CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
				cnop.createNewOrganisation(ORGNAME, INDUSTRY);
				Reporter.log("Organisation Created With Industry",true);
				
				//Step8: Vlidate
				OrganisationInfoPage oip=new OrganisationInfoPage(driver);
				String OrgHeader=oip.getHeader();	
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
	}

}
