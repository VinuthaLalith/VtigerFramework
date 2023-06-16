package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility{   //Rule1: Create Class
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement organisationName;
	
	@FindBy(name="industry")
	private WebElement industryName;
	
	@FindBy(name="accounttype")
	private WebElement accType;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
    //Utilization
	public WebElement getOrganisationName() {
		return organisationName;
	}

	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getAccType() {
		return accType;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library
	/**
	 * This method will create new organisation
	 * @param ORGNAME
	 */
	public void createNewOrganisation(String ORGNAME) {
	organisationName.sendKeys(ORGNAME);	
	saveBtn.click();
	}
	
	/**
	 * This method will cretae organisation with industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganisation(String ORGNAME,String INDUSTRY) {
		organisationName.sendKeys(ORGNAME);	
		industryName.sendKeys(INDUSTRY);
		saveBtn.click();
		
		}
	
	/**
	 *  This method will cretae organisation with industry dropdown and type dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganisation(String ORGNAME,String INDUSTRY,String TYPE) {
		organisationName.sendKeys(ORGNAME);	
		industryName.sendKeys(INDUSTRY);
		accType.sendKeys(TYPE);
		saveBtn.click();
		
		}
	

	}
	
	

