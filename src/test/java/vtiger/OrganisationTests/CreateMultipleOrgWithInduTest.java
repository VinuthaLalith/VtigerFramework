package vtiger.OrganisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

public class CreateMultipleOrgWithInduTest extends BaseClass{
	
		
			@Test(dataProvider="getData")
			public void createOrgTest(String ORG,String INDUSTRY) throws IOException {
				String ORGNAME = ORG+jutil.getRandomNumber();
				 
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
				 String OrgnHeader=oip.getHeader();
				 Assert.assertTrue(OrgnHeader.contains(ORGNAME));
				 
			}
			
			@DataProvider
			public Object[][] getData() throws EncryptedDocumentException, IOException{
				
				return eutil.readMultipleData("DataProviderOrg");
			}
			

}
