package com.koch.Pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.koch.Utility.BrowserFactory;
import com.koch.Utility.GlobalVar;
import com.koch.Utility.Helper;
import com.koch.Utility.Initializer;

public class BaseClass {
	public static WebDriver Driver;
	public static ExtentReports  report=null;
	public static ExtentTest logger;

	@BeforeSuite
	public static void SetupSuite() throws Throwable {
		
		Initializer.initialize();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/CIMReports_" + Helper.GetCurrentDateFormat()+ ".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	


	@BeforeClass
	public static void StartUpApplication() {

		GlobalVar.Driver = BrowserFactory.StartApplication(GlobalVar.Driver, GlobalVar.Browser, GlobalVar.URL);
		System.out.println("Application Title : - " + GlobalVar.Driver.getTitle());

	}

	@AfterClass
	
	public static void Logout() {
		GlobalVar.Driver.manage().deleteAllCookies();
		BrowserFactory.QuitBrowser(GlobalVar.Driver);

	}
	
	@AfterMethod
	public void ScreenshotMethod(ITestResult result) throws Throwable {
		if(result.getStatus()==ITestResult.FAILURE) {
		//Helper.getScreenshot(GlobalVar.Driver);
		logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(GlobalVar.Driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
			logger.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(GlobalVar.Driver)).build());	
		}
		report.flush();
		
	}

}
