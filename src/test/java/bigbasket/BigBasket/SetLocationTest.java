package bigbasket.BigBasket;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bigbasket.BigBasket.pageObjects.HomePageObject;
import bigbasket.BigBasket.resources.Base;

public class SetLocationTest extends Base{
	
	private static final Logger logger = LogManager.getLogger(SetLocationTest.class.getName());
	public WebDriver driver;
	
	public String pincode;
	public String cityexpeted;
	public String footerlinksize;
	

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		logger.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		logger.info("URL is opened "+prop.getProperty("url"));
	};
	
	@DataProvider
	public Object[][] data() throws Exception{
		
		Object[][] myData;
		myData = Datadriven("./src/main/java/bigbasket/BigBasket/resources/testdata/TestData.xlsx");
		
		return myData;
	}
	
	@Test(dataProvider ="data")
	public void locationset(String pincode,String cityexpected,String footerlinksize) 
	{
		this.pincode = pincode;
		this.cityexpeted = cityexpected;
		this.footerlinksize = footerlinksize;
		
		HomePageObject homePageObj= new HomePageObject(driver);
		homePageObj.getlocationSetButton().click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		homePageObj.getcitySetDropdown().click();
		homePageObj.getselectcityoption().click();
		homePageObj.getpincodeTextBox().sendKeys(pincode);
		homePageObj.gettest().click();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		homePageObj.getcontinueButton().click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		logger.info("Location is set");
		String CityActual = homePageObj.getLocation().getText();
		Assert.assertEquals(CityActual, cityexpected);
		
		String contactNumber = homePageObj.getcontactNumberText().getText();
		String loginLink = homePageObj.getLoginButton().getText();
		String SignupLink = homePageObj.getSignUpButton().getText();
		logger.info(contactNumber + " " + loginLink + " " + SignupLink);
		logger.info("Headers are verified");
		
		System.out.println("Number of footer links is : " + homePageObj.getfooterLinks().size());
		int size = homePageObj.getfooterLinks().size();
		String s = Integer.toString(size);
		Assert.assertEquals(footerlinksize, s);
		logger.info("Footers are verified");
		
	}	 
		
	
	
	@AfterTest
	public void tearDown() 
	{
		driver.close();
		driver.quit();
		logger.info("driver is closed");
	}

}
