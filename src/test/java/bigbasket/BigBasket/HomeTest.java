package bigbasket.BigBasket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bigbasket.BigBasket.pageObjects.HomePageObject;
import bigbasket.BigBasket.resources.Base;

public class HomeTest extends Base{
	
	private static final Logger logger = LogManager.getLogger(HomeTest.class.getName());
	public WebDriver driver;
	
	@Test(priority = 1)
	public void HomePageTitleTest() 
	{
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		 String title= driver.getTitle();
		 String expectedTitle ="Online Grocery Shopping and Online Supermarket in India - bigbasket";
		 assertEquals(title, expectedTitle);
	}
	
	@Test(priority = 2)
	public void HomePageSearch() 
	{
		HomePageObject homePageObj= new HomePageObject(driver);
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    homePageObj.getSearchBox().sendKeys("soap");
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    homePageObj.getSearchBoxButton().click();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    assertTrue(true);
	}	 
		
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		logger.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		logger.info("URL is opened "+prop.getProperty("url"));
	};
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit();
		logger.info("driver is closed");
	}

}
