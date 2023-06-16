package vtiger.OpportunitiesTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import objectRepository.ConatctInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.CreateNewOpportunityPage;
import objectRepository.HomePage;
import objectRepository.OppoertunitiesPage;
import objectRepository.OpportunitiesInfoPage;

@Listeners(genericUtilities.ListenersImplimentation.class)
public class CreateOpportunitiesWithContactTests extends BaseClass{

	@Test
	public  void createOppWithContactTests() throws IOException {
		
				//From Excel file
				 String OPPNAME=eutil.readDataFromExcel("Opportunities", 1, 2);
				 String CONTACT=eutil.readDataFromExcel("Opportunities", 1, 3);
				 String LASTNAME=eutil.readDataFromExcel("Opportunities", 1,4);
				 
				//  Navigate to Contacts link
					HomePage hp=new HomePage(driver);
					hp.clicknContactsLink();
					
				// click on create contact look up Image
					ContactsPage cp=new ContactsPage(driver);
					cp.clickOnContactsLookImg();
					
				// Create Contact
					CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
					cncp.createNewContact(LASTNAME);
					
				// Validate for Conatact created
					ConatctInfoPage cip=new ConatctInfoPage(driver);
					String ContactHeader = cip.getContactHeader();
					Assert.assertTrue(ContactHeader.contains(LASTNAME));
							
				 //Navigate to Opportunities
				   hp.clickOnOpportunitiesLink();
				
				//Click on Create Opportunity Look up image
				OppoertunitiesPage op=new OppoertunitiesPage(driver);
				op.clikOnOppLookUp();
				
				//Create new Opportunity with mandatory fields
				CreateNewOpportunityPage cnop=new CreateNewOpportunityPage(driver);
				cnop.createNewOpportunity(driver, OPPNAME, CONTACT, LASTNAME);
				
				//Validate for Opportunity
				OpportunitiesInfoPage oip=new OpportunitiesInfoPage(driver);
				String OppHeadetText=oip.getOppHeader();
				Assert.assertTrue(OppHeadetText.contains(OPPNAME));
				 		 

	}

}
