package bigbasket.BigBasket.pageObjects;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePage {
	
	
	//@FindBy(className="hvr-drop")
	public WebElement category;
	public WebElement fruits;
	
	WebDriver driver;

	private int retryCount=0;
	
	public HomePageObject(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	
	By locationSetButton = By.xpath("//span[@class='arrow-marker']");
	public WebElement getlocationSetButton()
	{
		return driver.findElement(locationSetButton);
	}
	
	By citySetDropdown = By.xpath("(//div[@placeholder=\"Select your city\"])[1]");
	public WebElement getcitySetDropdown()
	{
		return driver.findElement(citySetDropdown);
	}
	
	By selectcityoption = By.xpath("//a[@class='ui-select-choices-row-inner']/span[text()='Bangalore']");
	public WebElement getselectcityoption()
	{
		return driver.findElement(selectcityoption);
	}
	
	By pincodeTextBox = By.xpath("(//input[@qa='areaInput'])[1]");
	public WebElement getpincodeTextBox()
	{
		return driver.findElement(pincodeTextBox);
	}
	
	By contactNumberText = By.xpath("//span[@qa='supportNumber']");
	public WebElement getcontactNumberText()
	{
		return driver.findElement(contactNumberText);
	}
	
	By continueButton = By.xpath("//*[@id=\"headerControllerId\"]/header/div/div/div/div/ul/li[2]/div/div/div[2]/form/div[3]/button");
	public WebElement getcontinueButton()
	{
		return driver.findElement(continueButton);
	}
	
	By test = By.xpath("//*[@id=\"headerControllerId\"]/header/div/div/div/div/ul/li[2]/div/div");
	public WebElement gettest()
	{
		return driver.findElement(test);
	}

	
	By getLocation = By.xpath("//span[@ng-bind='vm.user.currentAddress.city_name']");
	public WebElement getLocation()
	{
		return driver.findElement(getLocation);
	
	}
	
	By LoginButton = By.xpath("(//a[@qa='loginLink'])[2]");
	public WebElement getLoginButton()
	{
		return driver.findElement(LoginButton);
	}
	
	By SignUpButton = By.xpath("(//a[@qa='signUpLink'])[2]");
	public WebElement getSignUpButton()
	{
		return driver.findElement(SignUpButton);
	}
	
	By footerLinks = By.xpath("//div[@class='container footer-links']//a");
	public List<WebElement> getfooterLinks()
	{
		return driver.findElements(footerLinks);
	}
	
	By ShopByCatagory = By.xpath("//a[@qa='categoryDD']");
	public WebElement getShopByCatagory()
	{
		return driver.findElement(ShopByCatagory);
	}
	
	By CleanOption = By.xpath("(//a[text()='Cleaning & Household'])[2]");
	public WebElement getCleanOption()
	{
		return driver.findElement(CleanOption);
	}

	
	public WebElement getCategoryDropDown() throws InterruptedException {
		try {
			if(retryCount==5)
				return category;
			category=driver.findElement(By.className("meganav-shop"));
		}catch(NoSuchElementException e) {
			retryCount++;
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			getCategoryDropDown();
		}catch(StaleElementReferenceException e) {
			retryCount++;
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			getCategoryDropDown();
		}finally {
			retryCount=0;
		}
		return category;
	}
	
	public void clickFruitsVegitable(){
		 driver.findElement(By.partialLinkText("Fruits & Vegetables")).click();
	}
	
	public String getSelectedCategory() {
		return driver.findElement(By.xpath("//span[@itemprop=\"title\"]")).getText();
	}
	
	public void enterSearchText(String text) throws InterruptedException {
		if(retryCount>=5)
			return;
		try {
		driver.findElement(By.xpath("//input[@placeholder='Search for Products..']")).sendKeys(text);
		driver.findElement(By.xpath("//input[@placeholder='Search for Products..']")).sendKeys(Keys.ENTER);;
		}catch(ElementNotInteractableException e) {
			retryCount++;
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			enterSearchText(text);
		}catch(StaleElementReferenceException e) {
			retryCount++;
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			enterSearchText(text);
		}finally {
			retryCount=0;
		}
	}
	
	public String getErrorMessage() {
		return driver.findElement(By.xpath("//p[contains(text(),'We are sorry, no results found.')]")).getText();
	}
	
	public void hoverOnCategory() throws InterruptedException {
		
		mouseHover(getCategoryDropDown());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}
	
	By shopByCategory = By.xpath("//a[contains(text(),'Shop by Category')]");
	public WebElement getshopByCategory()
	{
		return driver.findElement(shopByCategory);
	}
	
	By searchBox = By.xpath("//input[@qa='searchBar']");
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	By searchBoxButton = By.xpath("//button[@qa='searchBtn']");
	public WebElement getSearchBoxButton()
	{
		return driver.findElement(searchBoxButton);
	}
	
	
	By categoryItems = By.xpath("//ul[@class='dropdown-menu']//ul[@id='navBarMegaNav']//li");
	public List<WebElement> getCategoryItems(){ return driver.findElements(categoryItems);}
	
	By closeChangeLocation = By.xpath("//span[@class='close-btn' and contains(@ng-click,'cityMessageClose')]");
	public WebElement getCloseChangeLocationIcon() {return driver.findElement(closeChangeLocation);}
	
	By noResultFound = By.xpath("//div[@class='search-result']/p[contains(text(),'No results found for')]");
	public WebElement getNoresultFound() {return driver.findElement(noResultFound);}
}

