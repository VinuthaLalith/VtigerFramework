package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisationspage { // Rule1: Cerate class
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
     private WebElement orgLookUpImg;
	
	//Initialization
	public Organisationspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	//Utilization

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}
	
	//Byusiness Library
	/**
	 * This method will click on Organisation Lookup image
	 */
	public void clickOnOrgLookUpImg() {
	orgLookUpImg.click();	
		
	}

	
}
