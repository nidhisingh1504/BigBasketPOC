package bigbasket.BigBasket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bigbasket.BigBasket.pageObjects.CleaningHouseholdPageObject;
import bigbasket.BigBasket.pageObjects.HomePageObject;
import bigbasket.BigBasket.resources.Base;

public class FilterProductsTest extends Base{
	
	private static final Logger logger = LogManager.getLogger(FilterProductsTest.class.getName());
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		logger.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		logger.info("URL is opened "+prop.getProperty("url"));
	};
	
	
	@Test()
	public void filter() throws InterruptedException 
	{
		HomePageObject homePageObj= new HomePageObject(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(homePageObj.getShopByCatagory()).build().perform();
		action.moveToElement(homePageObj.getCleanOption()).click().build().perform();
		
		CleaningHouseholdPageObject  cleanHoldPageObj = new CleaningHouseholdPageObject(driver);
	    
		cleanHoldPageObj.getSearchBrandBox().sendKeys("BB Home");
		cleanHoldPageObj.getBBHomeCheckBox().click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		int size = cleanHoldPageObj.getBBHomeFilteredProducts().size();
		logger.info("Total products dispayed is : " + size);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		Thread.sleep(2000);
		for(int i=0;i<size;i++) {
			
				if(!cleanHoldPageObj.getBBHomeFilteredProducts().get(i).getText().equalsIgnoreCase("BB Home"))
					
					logger.error("Filter products are not displaying properly");
		}
		
		logger.info("Filtered products are verified");
		
	}
		
	
	
	@AfterMethod
	public void tearDown() 
	{
		
		driver.close();
		driver.quit();
		logger.info("driver is closed");
	}


}
