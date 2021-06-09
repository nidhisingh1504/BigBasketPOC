package bigbasket.BigBasket.resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
public WebDriver driver;
public Properties prop;

public WebDriver initializeDriver() throws IOException
{
	prop= new Properties(); 
	String path= "./src/main/java/bigbasket/BigBasket/resources/data.properties";
	//String chromeDriverPath = "C://software//chromedriver//chromedriver.exe";
	
	System.out.print("path "+path);
	
	FileInputStream fis = new FileInputStream(path);
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	String chromeDriverPath = prop.getProperty("chromeDriverpath");
	System.out.print("Base "+browserName);
	System.out.print("Chrome Driver Path "+chromeDriverPath);
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver= new ChromeDriver();
	}
	
	else if(browserName=="firefox") {
		System.setProperty("webdriver.firefox.driver", "C://software//firefoxdriver//firefoxdriver.exe");
		driver= new FirefoxDriver();
	}
	
   else if(browserName=="Mozilla") {
	   System.setProperty("webdriver.firefox.driver", "C://software//mozilladriver//Mozilladriver.exe");
	   driver= new FirefoxDriver();
	}
	
   else if(browserName=="IE") {
	   System.setProperty("webdriver.IE.driver", "C://software//IEdriver//IE.exe");
	   driver= new InternetExplorerDriver();
	}
	
   else {
	   System.out.print("Please check browser name");
   }
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
{
	 System.out.print("Base Screenshot");
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	 System.out.print("destination file "+destinationFile);
	 FileUtils.copyFile(source, new File(destinationFile));
	 return destinationFile;	 
}
}
