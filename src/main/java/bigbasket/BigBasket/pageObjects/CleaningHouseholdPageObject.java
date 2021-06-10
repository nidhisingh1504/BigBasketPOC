package bigbasket.BigBasket.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CleaningHouseholdPageObject {
	
	WebDriver driver;
	
	public CleaningHouseholdPageObject(WebDriver driver){
		
		this.driver=driver;
	}
	
	By SearchBrandBox = By.xpath("(//input[@value='Search by Brand'])[1]");
	public WebElement getSearchBrandBox()
	{
		return driver.findElement(SearchBrandBox);
	}
	
	By BBHomeCheckBox = By.xpath("//*[@id=\"filterbar\"]/div[4]/div[2]/section/div[1]/label/span[1]");
	public WebElement getBBHomeCheckBox()
	{
		return driver.findElement(BBHomeCheckBox);
	}
	
	By BBHomeFilteredProducts = By.xpath("//div[@qa='product_name']/h6");
	public List<WebElement> getBBHomeFilteredProducts()
	{
		return driver.findElements(BBHomeFilteredProducts);
	}

}
