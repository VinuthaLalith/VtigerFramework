package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	
	//declaration
	@FindBy(name="vendorname")
	private WebElement VendorNameEdt;
	
	@FindBy(name="glacct")
	private WebElement GLAccount;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}

	public WebElement getGLAccount() {
		return GLAccount;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//Business Library
	/**
	 *
	 *This method will create new vendor 
	 * @param VENDORNAME
	 * @param ACCOUNT
	 */
	public void createNewVendor(String VENDORNAME,String ACCOUNT) {
	VendorNameEdt.sendKeys(VENDORNAME);
	GLAccount.sendKeys(ACCOUNT);
	SaveBtn.click();
	
	}
}
