package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	
	public void waitForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void waitForElementToBeVisisble(WebDriver driver,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
    public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	
	public void handleDropDown(WebElement element,int index) {
		
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
     public void handleDropDown(WebElement element,String value) {
		
		Select sel=new Select(element);
		sel.selectByValue(value);
	}

     /**
      * This method will handle dropdown by visible text
      * @param visibletext
      * @param element
      */
     public void handleDropDown(String visibletext,WebElement element) {
	
	Select sel=new Select(element);
	sel.selectByVisibleText(visibletext);
}

     public void mouseOverAction(WebDriver driver,WebElement element) {
    	 
    	 Actions action=new Actions(driver);
    	 action.moveToElement(element).perform();
     }
     

     /**
      * This method wil right click anywhere on webpage
      * @param driver
      */
     
     public void rightClickAction(WebDriver driver) {
    	 
    	 Actions action=new Actions(driver);
    	 action.contextClick().perform();
     }  
     
     /**
      * This method will right click on particular element
      * @param driver
      * @param element
      */
  
    public void rightClickAction(WebDriver driver,WebElement element) {
    	 
    	 Actions action=new Actions(driver);
    	 action.doubleClick(element).perform();
     }
    
    /**
     * This method wil double click anywhere on webpage
     * @param driver
     */
    
    public void doubleClickAction(WebDriver driver) {
      	 
      	 Actions action=new Actions(driver);
      	 action.doubleClick().perform();
       }  
    
     /**
      * This method will double click on particular element
      * @param driver
      * @param element
      */
        
     public void doubleClickAction(WebDriver driver,WebElement element) {
   	 
   	 Actions action=new Actions(driver);
   	 action.contextClick(element).perform();
    }
     
     /**
      * This method drag and drop from source element to target element 
      * @param driver
      * @param srcelement
      * @param targelement
      */
  
     public void dradAndDropAction(WebDriver driver,WebElement srcelement,WebElement targelement) {
	   	 
	   	 Actions action=new Actions(driver);
	   	 action.dragAndDrop(srcelement, targelement).perform();
	    }  
     
     /**
      * This method drag and drop from source element to target element offsets
      * @param driver
      * @param srcelement
      * @param x
      * @param y
      */
     public void dradAndDropAction(WebDriver driver,WebElement srcelement,int x,int y) {
	   	 
	   	 Actions action=new Actions(driver);
	   	 action.dragAndDropBy(srcelement, x,y).perform();
	    }  

     
     /**
      * This element will handle the frame by index
      * @param driver
      * @param index
      */
	 public void switchToFrame(WebDriver driver,int index) {
		 
		 driver.switchTo().frame(index);
	 }
	 
	  /**
      * This element will handle the frame by name or Id
      * @param driver
      * @param index
      */
 public void switchToFrame(WebDriver driver,String nameOrId) {
		 
		 driver.switchTo().frame(nameOrId);
	 }
 
 /**
  * This element will handle the frame by webelement
  * @param driver
  * @param index
  */
 
 public void switchToFrame(WebDriver driver,WebElement element) {
	 
	 driver.switchTo().frame(element);
 }

 public void switchToParentFrame(WebDriver driver) {
	 
	 driver.switchTo().parentFrame();
 }
 

 public void switchToDefaultFrame(WebDriver driver) {
	 
	 driver.switchTo().defaultContent();
 }
 
 
 public void acceptAlert(WebDriver driver) {
	 
	 driver.switchTo().alert().accept();
 }
 
 public void dismisstAlert(WebDriver driver) {
	 
	 driver.switchTo().alert().dismiss();
 }
 
 
 public void getAlertText(WebDriver driver) {
	 
	 driver.switchTo().alert().getText();
 }
   
     
 public String takeScreenShot(WebDriver driver,String screenShotname) throws IOException {
	 
	 TakesScreenshot ts=(TakesScreenshot) driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File des=new File(".\\ScreenShots\\"+screenShotname+".png");
	                                      //screenshot1.png
	 Files.copy(src, des);
	 return des.getAbsolutePath();   //To get the complete file location//used for extent reports
	 
 }
   
 
 public void scrollAction(WebDriver driver) {
	   
	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   js.executeScript("windows.scrollBy(0,500);", null);
	   
   }
     

	 public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		 
		 //Step1: capture all window ids
		 Set<String> winIds = driver.getWindowHandles();
		 
		 //Step2: navigate to each window
		 for (String winId : winIds) {
			 
			 //Step3: Capture the title of each window
			 
			 String actTilte=driver.switchTo().window(winId).getTitle();
			 
			 //Step4:  Compare the title
			 
			 if(actTilte.contains(partialWindowTitle))
			 {
				 break;
				 
			 }
			
		}
	 }
  

}
