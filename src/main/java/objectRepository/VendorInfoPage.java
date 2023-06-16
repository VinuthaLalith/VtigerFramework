package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement VendoreHeaderText;
	
	//Initialization
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getVendoreHeaderText() {
		return VendoreHeaderText;
	}
	
	//Business Library
	/**
	 * This method will return vendor header
	 * @return
	 */
	public String getVendorHeader() {
		return VendoreHeaderText.getText();
		
	}
	

}
