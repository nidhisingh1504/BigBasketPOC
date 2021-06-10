package bigbasket.BigBasket;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bigbasket.BigBasket.pageObjects.AllProductObject;
import bigbasket.BigBasket.pageObjects.HomePageObject;
import bigbasket.BigBasket.pageObjects.MyBasketObject;
import bigbasket.BigBasket.resources.Base;

public class HomeTest extends Base{
	
	private static final Logger logger = LogManager.getLogger(HomeTest.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		logger.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		logger.info("URL is opened "+prop.getProperty("url"));
	};
	
	@Test(priority = 1)
	public void HomePageTitleTest() 
	{
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		 String title= driver.getTitle();
		 String expectedTitle ="Online Grocery Shopping and Online Supermarket in India - bigbasket";
		 assertEquals(title, expectedTitle);
	}
	
	@Test(priority = 2)
	public void clickOnFruitsAndVegitables() throws InterruptedException 
	{
		HomePageObject home=new HomePageObject(driver);
		
		home.hoverOnCategory();
		Thread.sleep(500);
		home.clickFruitsVegitable();
		String cat=home.getSelectedCategory();
		
		assertEquals(cat.toLowerCase(),"Fruits & Vegetables".toLowerCase());
		logger.info("clicking on products is also done");
	}
	
	@Test(priority = 3)
	public void HomePageSearch() 
	{
		HomePageObject homePageObj= new HomePageObject(driver);
	  
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    homePageObj.getCloseChangeLocationIcon().click();
	    homePageObj.getSearchBox().sendKeys("abcd");
	    
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    homePageObj.getNoresultFound().isDisplayed();
	    String result=homePageObj.getNoresultFound().getText();
	    logger.info("result: "+result);
	    homePageObj.getSearchBox().clear();
	    
	    homePageObj.getSearchBox().sendKeys("soap");
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    homePageObj.getSearchBoxButton().click();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    assertTrue(true);
	}	
	
	
	@Test(priority = 4)
	public void add5ItemsDelete1ItemAndViewCart() throws InterruptedException
	{
		AllProductObject allProduct= new AllProductObject(driver);
		MyBasketObject mybasket =new MyBasketObject(driver);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;	
		mybasket.getMyBasket().click();
	    String itemNosString=  mybasket.getCartItemNos().getText();
	    String cartItems = itemNosString.substring(0, itemNosString.indexOf("items"));
	    logger.info("The no of cartItems"+cartItems);
	    
	    if(!cartItems.equalsIgnoreCase("0")) {
	    	List<WebElement> removeBtns = mybasket.getItemRemoveButton();
	    	for(WebElement btn: removeBtns) {
	    		btn.click();
	    	}
	    }
	    List<WebElement> addItemsElements=allProduct.getaddItemBtn();	    
	    for(int i=0;i<5;i++) {
	    		addItemsElements.get(i).click();
	     }
	    
	    driver.manage().window().maximize();
	    WebElement element = mybasket.getMyBasketIcon();
	    Actions action = new Actions(driver);	
	    action.moveToElement(element).click(element).perform();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    
	    WebElement subtotal1 = mybasket.getSubtotal();
	    String subtotalBefore=subtotal1.getText();
	    logger.info("subtotalBefore "+subtotalBefore);
	    List<WebElement> removeBtns = mybasket.getItemRemoveButton();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", removeBtns.get(0));
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	    action.moveToElement(allProduct.getAllProductBtn()).perform();
	    action.moveToElement(element).click(element).perform();
	    Thread.sleep(10000);
	    WebElement subtotal2 = mybasket.getSubtotal();
	    String subtotalAfter=subtotal2.getText();
	    logger.info("subtotalAfter "+subtotalAfter);
	    Assert.assertNotEquals(subtotalBefore, subtotalAfter);
	}
	
		 
	
	
	
	@Test(priority = 5)
	public void searchByCategory()
	{
		HomePageObject homePageObj= new HomePageObject(driver);
	    
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	    homePageObj.getshopByCategory().click();
	    List<WebElement> lst= homePageObj.getCategoryItems();
	    for(WebElement elm:lst) {
	    	logger.info(elm.getText());
	    }
	}
	

	
		
	@Test(priority =6)
	public void searchWrongText() throws InterruptedException 
	{
		HomePageObject home=new HomePageObject(driver);
		
		home.enterSearchText("zyxdfg");
		String msg=home.getErrorMessage();
		assertEquals(msg,"We are sorry, no results found.");
		logger.info("Search of wrong product is done");
	}	 
	
	
	
	@AfterTest
	public void tearDown() 
	{
		driver.close();
		driver.quit();
		logger.info("driver is closed");
	}

}
