package bigbasket.BigBasket.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
	public Actions action;
	
	public BasePage(WebDriver driver) {
		action= new Actions(driver);
	}
	
	public void mouseHover(WebElement element) {
		Actions action1=action.moveToElement(element);
		action1.perform();
	}
}
