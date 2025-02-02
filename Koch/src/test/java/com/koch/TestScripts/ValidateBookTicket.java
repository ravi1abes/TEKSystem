package com.koch.TestScripts;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.koch.Pages.BaseClass;
import com.koch.Pages.HomePage;
import com.koch.Pages.ResultPage;
import com.koch.Utility.GlobalVar;

public class ValidateBookTicket extends BaseClass {
	
	@Test
	public static void TestBookTicketfunctionality() throws InterruptedException {
		
		HomePage homepage = PageFactory.initElements(GlobalVar.Driver, HomePage.class);
		ResultPage resultpage = PageFactory.initElements(GlobalVar.Driver, ResultPage.class);
		logger=report.createTest("TC_Validate Book Ticket :- " + "Validate the User is able to search the flight ticket");
		//loggers.info("Application  :- " );
		String ActualApplicationTitle="ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking";
		String ExpectedApplicationTitle =GlobalVar.Driver.getTitle();
		//Validate the Page
		Assert.assertEquals(ActualApplicationTitle, ExpectedApplicationTitle);
		//Enter From City
		String FromCity = homepage.EnterFromCity("PNQ");
		Reporter.log("Enter From City :-" + FromCity , true);
		String Tocity = homepage.EnterToCity("HYD");
		Reporter.log("Enter To City :- " + Tocity , true);
		homepage.EnterDepartureDate("21092020");
		Reporter.log("Enter Departure Date :- 21 Sep 2020 " , true);
		homepage.EnterReturnDate("24102020");
		Reporter.log("Enter Return Date :- 24 Oct 2020 " , true);
		homepage.EnterTravellers("2");
		Reporter.log("Enter Traveller :- 2 " , true);
		homepage.ClickSearchBtn();
		Thread.sleep(1000);
		String PageTitle = GlobalVar.Driver.getTitle();
		if(PageTitle.contains("Pune-Hyderabad")) {
		Reporter.log("Result Page is displaying successully.");
		}else {
		Assert.fail("Result Page is not display successully.");
		}
		//Click on Non Stop
		resultpage.ClickNonStop();
	    //Get Fare Having Price <5000
		ArrayList<Integer> FareValue = resultpage.GetFare();
		int count = FareValue.size();
		Reporter.log("Total Number of flight having fare < 5000 :- " + count ,true ); 
		
	}

}
