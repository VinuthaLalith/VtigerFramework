package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {     //Rule1: create class
	
	//Rule2: identify the elements using annotations
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement Loginbtn;
	
	//Rule3: create a constructor to initialize
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	
	//Rule4: provide getters to access 
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public void setUserNameEdt(WebElement userNameEdt) {
		this.userNameEdt = userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public void setPasswordEdt(WebElement passwordEdt) {
		this.passwordEdt = passwordEdt;
	}

	public WebElement getLoginbtn() {
		return Loginbtn;
	}

	public void setLoginbtn(WebElement loginbtn) {
		Loginbtn = loginbtn;
	}
	
	//Business Libraries - project specific generic utilities
	/**
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void LogintoApp(String USERNAME, String PASSWORD) {
		
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		Loginbtn.click();
	}
	
	
	
	
	
	

}
