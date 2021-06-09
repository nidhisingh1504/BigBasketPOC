package bigbasket.BigBasket.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {
	
	public WebDriver driver;
	
	public HomePageObject(WebDriver driver)
	{
		this.driver= driver;
	}
	
	By searchBox = By.xpath("//input[@qa='searchBar']");
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	By searchBoxButton = By.xpath("//button[@qa='searchBtn']/i[@xpath='1']");
	public WebElement getSearchBoxButton()
	{
		return driver.findElement(searchBoxButton);
	}
	
}