package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaignLiikUpImg;
	
	//Initialisation
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    //Utilisation
	public WebElement getCreateCampaignLiikUpImg() {
		return createCampaignLiikUpImg;
	}
	
	/**
	 * Thsi method will click on create campaign look up image
	 */
	//Business Library
	public void clickOnCampaignLookUpImg() {
		createCampaignLiikUpImg.click();
	}
	
	

}
