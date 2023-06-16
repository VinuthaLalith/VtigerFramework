package vtiger.ContactsTests;

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
import objectRepository.ConatctInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.CreateNewOrganisationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganisationInfoPage;
import objectRepository.Organisationspage;

public class CreateContactWithOrganisationTest extends BaseClass{
	
	@Test
	public void createContWithOrgTest() throws IOException {
				 
				//From Excel file
				 String LASTNAME=eutil.readDataFromExcel("Contact", 4, 2);
				 String ORGNAME=eutil.readDataFromExcel("Contact", 4, 3)+jutil.getRandomNumber();
				
					//Step3: Click on Organisation
					HomePage hp=new HomePage(driver);
					hp.clickOnOrganisationLink();
					
					//Step4: Click on create org look up image
					Organisationspage op=new Organisationspage(driver);
					op.clickOnOrgLookUpImg();
					
					//Step5: Create organisation with mand fields
					CreateNewOrganisationPage cnop=new CreateNewOrganisationPage(driver);
					cnop.createNewOrganisation(ORGNAME);
					
					//Step7: Vlidate Organisation
				    OrganisationInfoPage oip=new OrganisationInfoPage(driver);
					String OrgnHeader=oip.getHeader();
					Assert.assertTrue(OrgnHeader.contains(ORGNAME));
					
					// Step 8: Navigate to Contacts link
					hp.clicknContactsLink();
					
					// Step 9: click on create contact look up Image
					ContactsPage cp=new ContactsPage(driver);
					cp.clickOnContactsLookImg();
					
					// Step 10: Create Contact
					CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
					cncp.createNewContact(driver, LASTNAME, ORGNAME);
					
					// Step 11: Validate for Conatact created
					ConatctInfoPage cip=new ConatctInfoPage(driver);
					String ContactHeader = cip.getContactHeader();
					Assert.assertTrue(ContactHeader.contains(LASTNAME));
			

}			 

}
