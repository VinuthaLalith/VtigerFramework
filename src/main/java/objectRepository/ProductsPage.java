package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement ProductsLookUpImg;
	
	//Initilization
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	//Utilization
	public WebElement getProductsLookUpImg() {
		return ProductsLookUpImg;
	}
	
	//Business Library
	/**
	 * This method will click on create Product Lookup image
	 */
	public void clickOnProductsLookUpImg() {
		
		ProductsLookUpImg.click();
	}

	

}
