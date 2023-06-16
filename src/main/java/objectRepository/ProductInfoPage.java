package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement ProductHeaderText;
	
	//Initialization
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getProductHeaderText() {
		return ProductHeaderText;
	}
	
	/**
	 * This method will return the Vednor Header Text
	 * @return
	 */
	public String getPorductHeader() {
		return ProductHeaderText.getText();
	}

}
