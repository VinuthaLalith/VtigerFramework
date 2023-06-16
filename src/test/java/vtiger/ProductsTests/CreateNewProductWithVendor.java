package vtiger.ProductsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewProductPage;
import objectRepository.CreateNewVendorPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;
import objectRepository.VendorInfoPage;
import objectRepository.VendoresPage;

public class CreateNewProductWithVendor extends BaseClass{

	@Test
	public void createProductWithVen() throws IOException {
		
		String PRODUCTNAME=eutil.readDataFromExcel("Products", 1, 2);
		String VENDORNAME=eutil.readDataFromExcel("Products", 1, 3);
		String ACCOUNT=eutil.readDataFromExcel("Products", 1, 4);
		
		//Step2: Click on Vendors
		HomePage hp=new HomePage(driver);
		hp.mouseOverMore(driver);
		
		//Step3: Click on create Vendor lookupmimage
			VendoresPage vp=new VendoresPage(driver);
				vp.clickOnVendorsLookUpImg();
				
		//Step4: Create new Vendor
			CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
			cnvp.createNewVendor(VENDORNAME, ACCOUNT);
			
		//Step5: Validate Vendor
			VendorInfoPage vip=new VendorInfoPage(driver);
			String VenHeader=vip.getVendorHeader();		
			Assert.assertTrue(VenHeader.contains(VENDORNAME));
		
		//Step6: Click on Products
		hp.clickOnProductsLink();
		
		//Step7: Click on create Product lookupmimage
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductsLookUpImg();
		
		//Step8: Create new Product
		CreateNewProductPage cnpp=new CreateNewProductPage(driver);
		cnpp.CreateNewProduct(driver, PRODUCTNAME, VENDORNAME, ACCOUNT);
		
		//Step9: Validate Product
		ProductInfoPage pip=new ProductInfoPage(driver);
		String ProHeader=pip.getPorductHeader();	
		Assert.assertTrue(ProHeader.contains(PRODUCTNAME));
		
		}	
	 

}
