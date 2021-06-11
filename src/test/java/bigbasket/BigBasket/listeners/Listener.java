package bigbasket.BigBasket.listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import bigbasket.BigBasket.resources.Base;
import bigbasket.BigBasket.resources.ExtentReporterNG;

public class Listener extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	
	@Override
	public void onTestStart(ITestResult result) {
		prop= new Properties(); 
		String path= "./src/main/java/bigbasket/BigBasket/resources/testdescriptions.properties";
		//String chromeDriverPath = "C://software//chromedriver//chromedriver.exe";
		
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    // TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName()+"<br>"+prop.getProperty(result.getMethod().getMethodName()));
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
    // TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

    // TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), testMethodName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
    // TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
    // TODO Auto-generated method stub
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
    // TODO Auto-generated method stub
		extent.flush();
	}

}
