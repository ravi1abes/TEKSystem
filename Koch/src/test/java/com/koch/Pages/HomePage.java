package com.koch.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.koch.Utility.GlobalVar;

public class HomePage {

	public WebDriver driver = null;

	public HomePage(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(xpath = "(.//input[@type='text'])[1]")
	public WebElement FromField;

	// Cross Icon of From Fields
	@FindBy(xpath = "(.//div[@class='clear-input ixi-icon-cross'])[1]")
	public WebElement CrossIconFromField;

	@FindBy(xpath = "(.//input[@type='text'])[2]")
	public WebElement ToField;

	@FindBy(xpath = ".//input[@placeholder='Depart']")
	public WebElement DepartDateField;

	/*
	 * @FindBy(id=".//td[@data-date='22092020']") public WebElement DepartDate;
	 */

	@FindBy(xpath = ".//input[@placeholder='Return']")
	public WebElement ReturnDatefield;
	/*
	 * @FindBy(id="(.//input[@type='text'])[2]") public WebElement ReturnDate;
	 */

	@FindBy(xpath = "(.//input[@class='c-input u-v-align-middle'])[5]")
	public WebElement TravellerField;

	@FindBy(xpath = "(.//div[@class='u-ib items u-v-align-middle'])[1]/span[2]")
	public WebElement Traveller;

	@FindBy(xpath = "(//div[@class='u-ripple'])[1]")
	public WebElement SearchBtn;

	public String EnterFromCity(String fromCity) {
		//CrossIconFromField.click();
		FromField.sendKeys(fromCity);
		//FromField.click();
		return fromCity;

	}
	public String EnterToCity(String ToCity) {
		//ToField.clear();
		ToField.sendKeys(ToCity);
		//ToField.click();
		return ToCity;

	}

	public String EnterDepartureDate(String DepDate) {
		DepartDateField.click();
		GlobalVar.Driver.findElement(By.xpath(".//td[@data-date='" + DepDate + "']")).click();
		return DepDate;

	}

	public String EnterReturnDate(String RetDate) {
		ReturnDatefield.click();
		GlobalVar.Driver.findElement(By.xpath("(.//td[@data-date='" + RetDate + "'])[2]")).click();
		return RetDate;

	}

	public String EnterTravellers(String TravellerNum) {
		TravellerField.click();
		GlobalVar.Driver
				.findElement(By.xpath("(.//div[@class='u-ib items u-v-align-middle'])[1]/span[" + TravellerNum + "]"))
				.click();
		return TravellerNum;

	}

	public void ClickSearchBtn() {
		SearchBtn.click();

	}

}
