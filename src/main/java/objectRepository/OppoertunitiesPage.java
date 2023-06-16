package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppoertunitiesPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement OppLookUpImg;
	
	//Initialization
	public OppoertunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getOppLookUpImg() {
		return OppLookUpImg;
	}
	
	//Business Library
	public void clikOnOppLookUp() {
		OppLookUpImg.click();
	}
	
	

}
