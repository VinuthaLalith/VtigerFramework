package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrganisationInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business Libnrary
	/**
	 * This method will return Organisation header text
	 * @return
	 */
	
	/**
	 * This method will return Organisation Header Text
	 * @return
	 */
	public String getHeader() {
		return orgHeaderText.getText();
	}


}
