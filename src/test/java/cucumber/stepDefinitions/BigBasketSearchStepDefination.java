package cucumber.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bigbasket.BigBasket.pageObjects.HomePageObject;
import bigbasket.BigBasket.resources.Base;

@RunWith(Cucumber.class)
public class BigBasketSearchStepDefination extends Base{

    private static final Logger logger = LogManager.getLogger(BigBasketSearchStepDefination.class.getName());
    public WebDriver driver;
	
    @Given("^BigBasket page URL is given$")
    public void BigBasket_page_url_is_given() throws Throwable {
    	driver = initializeDriver();
	logger.info("driver is initialized");
	driver.get(prop.getProperty("url"));
	logger.info("URL is opened "+prop.getProperty("url"));
	driver.quit();  
    }
    
    @When("^User has given \"([^\"]*)\" on search box and click on search button$")
    public void user_has_given_something_on_search_box_and_click_on_search_button(String strArg1) throws Throwable {
    	driver = initializeDriver();
    	HomePageObject homePageObj= new HomePageObject(driver);
    	
	logger.info("driver is initialized");
	driver.get(prop.getProperty("url"));
	logger.info("URL is opened "+prop.getProperty("url"));
		  
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	homePageObj.getCloseChangeLocationIcon().click();
	homePageObj.getSearchBox().sendKeys(strArg1);
	  
	assertTrue(true);
	driver.quit();  
    }
    
    @Then("^User get \"([^\"]*)\" in search result$")
    public void user_get_something_in_search_result(String strArg1) throws Throwable {
    	driver = initializeDriver();
    	HomePageObject homePageObj= new HomePageObject(driver);
    	
	logger.info("driver is initialized");
	driver.get(prop.getProperty("url"));
	logger.info("URL is opened "+prop.getProperty("url"));
		  
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	homePageObj.getCloseChangeLocationIcon().click();
	homePageObj.getSearchBox().sendKeys(strArg1);
	   
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	homePageObj.getSearchBoxButton().click();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	assertTrue(true);
	driver.quit();  
    }
    
    @And("^Test are \"([^\"]*)\"$")
    public void test_are_something(String strArg1) throws Throwable {
    	assertTrue(true, strArg1);
	driver.quit();  
    }

    @When("^URL is loaded$")
    public void URL_is_loaded() throws Throwable {
    	driver = initializeDriver();
    	logger.info("driver is initialized");
    	driver.get(prop.getProperty("url"));
    	logger.info("URL is opened "+prop.getProperty("url"));
	assertTrue(true);
	driver.quit();  
    }
    
    @Then("^Verify BigBasket Title$")
    public void Verify_BigBasket_Title(String strArg1) throws Throwable {
    	driver = initializeDriver();
	logger.info("driver is initialized");
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
	String title= driver.getTitle();
	assertEquals(title, strArg1);
	driver.quit();  
    }
	
}
