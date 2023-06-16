package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility{

	//Declaartion
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgLookImg;
	
	@FindBy(name="search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name="search")
	private WebElement orgSearchBtn;
	
	//Initialisation
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilisation
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgLookImg() {
		return orgLookImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}

	//Business Library
	/**
	 * This method will create new contact
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
		
	}
	
	/**
	 * This method will create new contact with Organisation
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME) {
		LastNameEdt.sendKeys(LASTNAME);
		orgLookImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		                                  //'Wipro636'
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
		
		
	}
	
}
