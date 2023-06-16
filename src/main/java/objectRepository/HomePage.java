package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{   //rule1: Create class
	
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganisationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText = "More")
	private WebElement MouseOverMoreLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement clickOnVendors;
	
	@FindBy(linkText = "Campaigns")
	private WebElement clickOnCampaigns;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logoutLink;
	
	//Initialization
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganisationLink() {
		return OrganisationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}
	
	public WebElement getMouseOverMoreLink() {
		return MouseOverMoreLink;
	}

	public WebElement getClickOnVendors() {
		return clickOnVendors;
	}
	
	public WebElement getClickOnCampaigns() {
		return clickOnCampaigns;
	}

	//Business library
	/**
	 * This method will click on Organisations Link
	 */
	public void clickOnOrganisationLink() {
		OrganisationLink.click();
		
	}
	/**
	 *  This method will click on Contacts Link
	 */
	public void clicknContactsLink() {
		ContactsLink.click();
		
	}
	
	
	/**
	 * This method will click on Opportunities link
	 */
	public void clickOnOpportunitiesLink() {
		opportunitiesLink.click();
	}
	
	/**
	 * This method will click on Products link
	 */
	public void clickOnProductsLink() {
		ProductsLink.click();
	}
	
	/**
	 * This method will SignOut from the application
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver) {
		mouseOverAction(driver, AdminstratorImg);
		logoutLink.click();
		//driver.quit();
		
	}
	
	/**
	 * This method will move mouse on More Link and select Vendors
	 * @param driver
	 */
	public void mouseOverMore(WebDriver driver) {
		mouseOverAction(driver, MouseOverMoreLink);
		clickOnVendors.click();
	}

	/**
	 * This method will click on Opportunities link
	 */
	public void clickonCampaignsLink(WebDriver driver) {
		mouseOverAction(driver,MouseOverMoreLink);
		clickOnCampaigns.click();
	
	}
}
