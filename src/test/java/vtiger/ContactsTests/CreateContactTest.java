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
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactTest extends BaseClass{
	
	@Test
	public void createContTest() throws IOException {
		
				//From Excel file
				 String LASTNAME=eutil.readDataFromExcel("Contact", 4, 2);
 	
					// Step 3: Navigate to Contacts link
						HomePage hp=new HomePage(driver);
						hp.clicknContactsLink();
						
					// Step 4: click on create contact look up Image
						ContactsPage cp=new ContactsPage(driver);
						cp.clickOnContactsLookImg();
						
					// Step 5: Create Contact
						CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
						cncp.createNewContact(LASTNAME);
						
					// Step 6: Validate for Conatact created
						ConatctInfoPage cip=new ConatctInfoPage(driver);
						String ContactHeader = cip.getContactHeader();
						Assert.assertTrue(ContactHeader.contains(LASTNAME));
						
			}		
	}

