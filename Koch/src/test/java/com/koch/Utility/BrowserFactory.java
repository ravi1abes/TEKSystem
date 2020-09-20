package com.koch.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	WebDriver driver;

	public static WebDriver StartApplication(WebDriver driver, String BrowserName, String Url) {

		if (BrowserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equals("FireFox")) {

		} else if (BrowserName.equals("IE")) {

		} else {
			System.out.println("We don't support this Browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void QuitBrowser(WebDriver driver) {

		driver.quit();

	}

}
