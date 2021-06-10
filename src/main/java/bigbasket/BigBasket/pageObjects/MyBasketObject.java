package bigbasket.BigBasket.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyBasketObject extends BasePage{

	WebDriver driver;
	WebDriverWait wait ;
	
	public MyBasketObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	By myBasketIcon = By.xpath("//span[@title='Your Basket']/i") ;
	public WebElement getMyBasketIcon() { 
		wait= new WebDriverWait(driver,30);
		return wait.until(ExpectedConditions.elementToBeClickable(myBasketIcon));
		
	}
	
	By subtotal = By.xpath("//div[contains(@class,'row sub-cost ng-scope')]//p[contains(text(),'Sub Total')]") ;
	public WebElement getSubtotal() {
		wait = new WebDriverWait(driver,30);
		return wait.until(ExpectedConditions.elementToBeClickable(subtotal));}
		
//	}
//	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Your Basket']/i")));
	By myBasket =By.xpath("//span[@class='basket-content']");
	public WebElement getMyBasket() {return driver.findElement(myBasket);}
	
	By itemNos= By.xpath("//span[@id='totalNumberOfCartItems']");
	public WebElement getCartItemNos() {
		return driver.findElement(itemNos);	
	}
	By itemRemove=By.xpath("//div[@class='item-remove' and text()='x']");
	public List<WebElement> getItemRemoveButton() {return driver.findElements(itemRemove);}
	
//	By subTotal = By.xpath("//div[contains(@class,'row sub-cost ng-scope')]//p[contains(text(),'Sub Total')]");
//	public WebElement getsubTotal() {return driver.findElement(subTotal);}
	
}