package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOpportunityPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name="potentialname")
	private WebElement PotentialnameEdt;
	
	@FindBy(id = "related_to_type")
	private WebElement RelatedTo;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement RelatedLookUpImg;
	
	@FindBy(xpath = "//input[@value='U']")
	private WebElement AssignedToRadioBtn;
	
	@FindBy(id = "search_txt")
	private WebElement ContactSearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialization
	public CreateNewOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getPotentialnameEdt() {
		return PotentialnameEdt;
	}

	public WebElement getRelatedTo() {
		return RelatedTo;
	}

	public WebElement getRelatedLookUpImg() {
		return RelatedLookUpImg;
	}

	public WebElement getAssignedToRadioBtn() {
		return AssignedToRadioBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getContactSearchEdt() {
		return ContactSearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public void createNewOpportunity(WebDriver driver,String OPPNAME, String CONTACT, String LASTNAME) {
		PotentialnameEdt.sendKeys(OPPNAME);
		RelatedTo.sendKeys(CONTACT);
		RelatedLookUpImg.click();
		switchToWindow(driver, "Contacts");
		
		ContactSearchEdt.sendKeys(LASTNAME);
		SearchBtn.click();
		                                            //Batman
		driver.findElement(By.xpath(" //a[text()=' "+LASTNAME+"']"));
		switchToWindow(driver, "Potentials");
		AssignedToRadioBtn.click();
		SaveBtn.click();
		
	}
	

}
