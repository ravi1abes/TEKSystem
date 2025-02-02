package com.koch.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.koch.Utility.GlobalVar;

public class ResultPage {
	@FindBy(xpath="(.//span[@class='ixi-icon-tick check-icon'])[1]")
	public WebElement ChkNonStop;
	
	public void ClickNonStop() {
		ChkNonStop.click();
		
	}
	
	//Print the fare
	@FindBy(xpath=".//div[@class='price']/div/span[2]")
	public List<WebElement> Fares;
	
	public ArrayList<Integer> GetFare() {
		ArrayList<Integer> farelist= new ArrayList<Integer>();
		int count = Fares.size();
		int ActualSize = count-1;
		for(int i=2;i<=count;i++) {
			
			String FareValue = Fares.get(i).getText();
			int FareActualVal = Integer.parseInt(FareValue);
			if(FareActualVal<5000) {
				farelist.add(FareActualVal);
				//WebElement DepTime = GlobalVar.Driver.findElement(By.xpath(".//div[@class='price']/div/span[1]/../../../../..//div[@class='time-group']/div[1]"));
				//String DepTimeTxt = DepTime.getText();
				//.//div[@class='price']/div/span[2]/../../../../div[3]/div[1]
		}
		
		}
		return farelist;
	
	}
	
	
	
	
	

}
