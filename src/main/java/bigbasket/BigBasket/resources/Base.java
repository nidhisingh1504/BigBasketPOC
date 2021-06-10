package bigbasket.BigBasket.resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
public WebDriver driver;
public Properties prop;

public static final Logger logger = LogManager.getLogger(Base.class.getName());

public WebDriver initializeDriver() throws IOException
{
	prop= new Properties(); 
	String path= "./src/main/java/bigbasket/BigBasket/resources/data.properties";
	//String chromeDriverPath = "C://software//chromedriver//chromedriver.exe";
	
	
	FileInputStream fis = new FileInputStream(path);
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	String chromeDriverPath = prop.getProperty("chromeDriverpath");
	String firefoxDriverPath = prop.getProperty("firefoxDriverpath");
	String ieDriverPath = prop.getProperty("IEDriverpath");
	
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver= new ChromeDriver();
	}
	
	else if(browserName=="firefox") {
		System.setProperty("webdriver.firefox.driver", firefoxDriverPath);
		driver= new FirefoxDriver();
	}
   else if(browserName=="IE") {
	   System.setProperty("webdriver.IE.driver", ieDriverPath);
	   driver= new InternetExplorerDriver();
	}
	
   else {
	  logger.info("Driver not initialized");
   }
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

public Object[][] Datadriven(String ExcelName) throws Exception {
	
	FileInputStream fis = new FileInputStream(ExcelName);
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet worksheet = workbook.getSheet("TestData");
	
	int rowCount = worksheet.getPhysicalNumberOfRows();
	
	Row firstRow = worksheet.getRow(0);
	int columnCount = firstRow.getPhysicalNumberOfCells();
	
	Object[][] data = new Object[rowCount][columnCount];
	
	
	for (int i = 0; i < rowCount; i++) // row level loop
	{
		XSSFRow row = worksheet.getRow(i);
		XSSFCell pincode = row.getCell(0);
		if(pincode==null) {
			
			data[i][0]= "";
		}
		else {
			
			pincode.setCellType(CellType.STRING);
			data[i][0] = pincode.getStringCellValue();
		}
		
		XSSFCell cityexpected = row.getCell(1);
		if(cityexpected==null) {
			
			data[i][1]= "";
		}
		else {
			
			data[i][1] = cityexpected.getStringCellValue();
		}
		
		XSSFCell footerlinksize = row.getCell(2);
		if(footerlinksize==null) {
			
			data[i][2]= "";
		}
		else {
			
			footerlinksize.setCellType(CellType.STRING);
			data[i][2] = footerlinksize.getStringCellValue();
		}
	}

   
	return data;
	
}

public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
{
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	 logger.info("destination file "+destinationFile);
	 FileUtils.copyFile(source, new File(destinationFile));
	 return destinationFile;	 
}
}
