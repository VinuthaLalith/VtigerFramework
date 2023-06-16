package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement CampHeadreText;
	
	//Initialisation
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//Utilisation
	public WebElement getCampHeadreText() {
		return CampHeadreText;
	}
	
	//Business Library
	/**
	 * This method will return Campaign header text
	 * @return
	 */
	public String getCampHeaderText()
	{
		return getCampHeaderText();
	}
	
}
