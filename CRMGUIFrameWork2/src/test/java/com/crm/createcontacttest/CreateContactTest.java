package com.crm.createcontacttest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactTest {

	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	
	@Test
	public void createContactTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		
		HomePage homePage = new HomePage(UtilityClassObject.getDriver());
		homePage.getContactLink().click();
		
	}
}
