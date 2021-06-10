package bigbasket.BigBasket.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllProductObject extends BasePage{

	WebDriver driver;
	
	public AllProductObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By ShopByCatagory = By.xpath("//a[@qa='categoryDD']");
	public WebElement getShopByCatagory(){return driver.findElement(ShopByCatagory);}
	
	By allProduct = By.xpath("//span[text()='All Products']");
	public WebElement getAllProductBtn() {return driver.findElement(allProduct);}
	
	
	By addItemBtn = By.xpath("//button[@qa='add']");
	public List<WebElement> getaddItemBtn() {return driver.findElements(addItemBtn);}
		
}