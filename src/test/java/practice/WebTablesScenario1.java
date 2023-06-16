package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesScenario1 {

	public static void main(String[] args) {
		//Step 1: launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		//Step 2: Login to Application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				System.out.println("Login successful");
				
				
		//Step 3: Click on Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[3]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[4]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[6]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[8]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[9]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[10]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[11]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[12]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[13]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[14]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[15]/td[1]")).click();
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[16]/td[1]")).click();
				
				
				//Step3: Logout
				WebElement admin = driver.findElement(By.xpath("//td[contains(@onmouseout,'fnHideDrop')]"));
				Actions action=new Actions(driver);
				action.moveToElement(admin).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				driver.quit();

	}

}
