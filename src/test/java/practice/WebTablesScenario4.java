package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesScenario4 {

	public static void main(String[] args) {
		
		//Step1: Launch the pplication
		
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        driver.get("http://localhost:8888");
		        
	    //Step2: Login to app
		        driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		
        //Step 3: Click on Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[16]/td[1]")).click();

	}

}
