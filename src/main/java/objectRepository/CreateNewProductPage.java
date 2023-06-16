package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name="productname")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement VendorLookUpImg;
	
	@FindBy(name="glacct")
	private WebElement GLAccount;
	
	@FindBy(name="search_text")
	private WebElement VendorNameSearchEdt;
	
	@FindBy(name="search")
    private WebElement VendorNameSearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialize
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilize
	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getVendorLookUpImg() {
		return VendorLookUpImg;
	}

	public WebElement getGLAccount() {
		return GLAccount;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getVendorNameSearchEdt() {
		return VendorNameSearchEdt;
	}

	public WebElement getVendorNameSearchBtn() {
		return VendorNameSearchBtn;
	}

	//Business Library
	/**
	 * This method will create new product with vendor
	 * @param driver
	 * @param PRODUCTNAME
	 * @param VENDORNAME
	 * @param ACCOUNT
	 */
	public void CreateNewProduct(WebDriver driver,String PRODUCTNAME,String VENDORNAME,String ACCOUNT) {
		ProductNameEdt.sendKeys(PRODUCTNAME);
		VendorLookUpImg.click();
		switchToWindow(driver, "Vendors");
		VendorNameSearchEdt.sendKeys(VENDORNAME);
		VendorNameSearchBtn.click();
		                            //"//a[.='Zenil']"
		driver.findElement(By.xpath("//a[.='" + VENDORNAME + "']")).click();
		switchToWindow(driver, "Products");
		GLAccount.sendKeys(ACCOUNT);
		SaveBtn.click();
		
	}
	
	/**
	 * Thus method will create new Product
	 * @param driver
	 * @param PRODUCTNAME
	 */
	public void CreateNewProduct(WebDriver driver,String PRODUCTNAME) {
		ProductNameEdt.sendKeys(PRODUCTNAME);
		SaveBtn.click();
		
		
	}
		

}
