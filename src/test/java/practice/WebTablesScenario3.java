package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesScenario3 {

	public static void main(String[] args) {
		//Step1: Launch the pplication
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://localhost:8888");
       
        //Step2: Login to app
        driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
        
        //Navigate to Organisations
        driver.findElement(By.linkText("Organizations")).click();
    	/*System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[3]")).getText());
    	System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[8]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[9]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[11]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[12]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[13]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[14]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[15]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[16]/td[3]")).getText());*/
        
      List<WebElement> Orgnames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/a[@title='Organizations']"));
      
    for (WebElement Orgname : Orgnames) {
    	System.out.println(Orgname.getText());
		
	}
		
        
	}

}
