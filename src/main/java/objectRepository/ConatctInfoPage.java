package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConatctInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Initialization
	public ConatctInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
				
	}

	//Utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business Library
	/**
	 * This method will retrun Contact Header Text
	 * @return
	 */
	public String getContactHeader() {
		return contactHeaderText.getText();
	}

	

}
