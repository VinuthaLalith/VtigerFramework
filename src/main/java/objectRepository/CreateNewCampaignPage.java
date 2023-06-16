package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import genericUtilities.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility{
	
	@FindBy(name="campaignname")
	private WebElement CampaignName;
	
	@FindBy(name="assigntype")
	private WebElement AssignType;
	
	@FindBy(name="campaigntype")
	private WebElement CampaignType;
	
	@FindBy(name="campaignstatus")
	private WebElement CampaignStatus;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement ProductLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement ProductsearchEdit;
	
	@FindBy(name="search")
	private WebElement ProductsearchBtn;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//Initialisation
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//Utilisation
	public WebElement getCampaignName() {
		return CampaignName;
	}
	
	public WebElement getAssignType() {
		return AssignType;
	}

	public WebElement getCampaignType() {
		return CampaignType;
	}

	public WebElement getCampaignStatus() {
		return CampaignStatus;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getProductLookUpImg() {
		return ProductLookUpImg;
	}

	public WebElement getProductsearchEdit() {
		return ProductsearchEdit;
	}

	public WebElement getProductsearchBtn() {
		return ProductsearchBtn;
	}

	/**
	 * This method will create new Campaign with product
	 * @param driver
	 * @param CAMPAIGNNAME
	 * @param CAMP_TYPE
	 * @param CAMP_STATUS
	 * @param PRODUCTNAME
	 */
	//Business Library
	public void createNewCampaign(WebDriver driver,String CAMPAIGNNAME,String CAMP_TYPE,String CAMP_STATUS,String PRODUCTNAME) {
		
		CampaignName.sendKeys(CAMPAIGNNAME);
		AssignType.click();
		CampaignType.sendKeys(CAMP_TYPE);
		CampaignStatus.sendKeys(CAMP_STATUS);
		ProductLookUpImg.click();
		switchToWindow(driver, "Products");
		ProductsearchEdit.sendKeys(PRODUCTNAME);
		ProductsearchBtn.click();
		
												    //Printer
		driver.findElement(By.xpath("//a[text()='"+PRODUCTNAME+"'])")).click();
		switchToWindow(driver, "Campaigns");
		SaveBtn.click();
		
	}

}
