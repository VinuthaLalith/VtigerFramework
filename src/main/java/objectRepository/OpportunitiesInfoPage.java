package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesInfoPage {
		
		//Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement OppHeaderText;
		
		//Initialisation
		public OpportunitiesInfoPage(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}

        //Utilisation
		public WebElement getOppHeaderText() {
			return OppHeaderText;
		}
		
		//Business Library
		/**
		 * This method will return Opportunities Header 
		 * @return
		 */
		public String getOppHeader() {
			return OppHeaderText.getText();
			
		}
		

	}

