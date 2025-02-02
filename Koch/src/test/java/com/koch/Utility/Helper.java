package com.koch.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// Capture Screenshot
	public static String getScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String Screenshotpath = System.getProperty("user.dir") + "/ScreenShots/CIM_" + GetCurrentDateFormat() + ".png";

		File destination = new File(Screenshotpath);

		try {
			FileHandler.copy(src, destination);
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unabale to capture the screenshot : - " + e.getMessage());
		}

		return Screenshotpath;
	}

	// Get Date format
	public static String GetCurrentDateFormat() {

		DateFormat currentformate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return currentformate.format(date);

	}

	// Sync Up Issue>>> Wait Element>> Customize Method

	public static WebElement isElementPresnt(WebDriver driver, String xpath, int time) {
		WebElement ele = null;

		for (int i = 0; i < time; i++) {
			try {
				ele = driver.findElement(By.xpath(xpath));
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		return ele;

	}

}
