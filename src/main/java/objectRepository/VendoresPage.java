package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendoresPage {
	
	//Declaration 
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement VendorsLookUpImg;
	
	//Initialization
	public VendoresPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	//Utilization
	public WebElement getVendorsLookUpImg() {
		return VendorsLookUpImg;
	}
	
	//Businesss Library
	/**
	 * This metyhod will click on vedor lookup image
	 */
	public void clickOnVendorsLookUpImg() {
		VendorsLookUpImg.click();
	}

	

}
