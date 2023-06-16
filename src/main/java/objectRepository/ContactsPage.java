package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement ContactsLookUpImg;
	
	//Initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	//Utilization
	public WebElement getContactsLookUpImg() {
		return ContactsLookUpImg;
	}
	
	//Businesss library
	/**
	 * This method will click on Contact lookup image
	 */
	public void clickOnContactsLookImg() {
		ContactsLookUpImg.click();
	}


}
