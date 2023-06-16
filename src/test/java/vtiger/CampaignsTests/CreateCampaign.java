package vtiger.CampaignsTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CampaignInfoPage;
import objectRepository.CampaignsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;

@Listeners(genericUtilities.ListenersImplimentation.class)
public class CreateCampaign extends BaseClass{
	
	@Test
	public void createCamp() throws IOException
	{
		//read data
		String CAMPAIGNNAME=eutil.readDataFromExcel("Campaigns", 1, 0);
		String CAMP_TYPE=eutil.readDataFromExcel("Campaigns", 1, 1);
		String CAMP_STATUS=eutil.readDataFromExcel("Campaigns", 1, 2);
		String PRODUCTNAME=eutil.readDataFromExcel("Campaigns", 1, 3);
		
		//Navigate to Products link
		HomePage hp=new HomePage(driver);
		hp.clickOnProductsLink();
		
		//Click on Products look up image
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductsLookUpImg();
		
		//Create new Product with mandatory fields
		CreateNewProductPage cnp=new CreateNewProductPage(driver);
		cnp.CreateNewProduct(driver, PRODUCTNAME);
		
		//Validte for product
		ProductInfoPage pip=new ProductInfoPage(driver);
		String ProHeader=pip.getPorductHeader();
		Assert.assertTrue( ProHeader.contains(PRODUCTNAME));
		
		//Navigate to Campaigns link
		hp.clickonCampaignsLink(driver);
		
		//click on campaigns Look Up image
		CampaignsPage cp=new CampaignsPage(driver);
		cp.clickOnCampaignLookUpImg();
		
		//Create new Campaign with mandatory fields
		CreateNewCampaignPage cncp=new CreateNewCampaignPage(driver);
		cncp.createNewCampaign(driver, CAMPAIGNNAME, CAMP_TYPE, CAMP_STATUS, PRODUCTNAME);
		
		//Validte for campaign
		CampaignInfoPage cip=new CampaignInfoPage(driver);
		String CampHeader=cip.getCampHeaderText();
		Assert.assertTrue(CampHeader.contains(CAMPAIGNNAME));
		
		
	}

}
