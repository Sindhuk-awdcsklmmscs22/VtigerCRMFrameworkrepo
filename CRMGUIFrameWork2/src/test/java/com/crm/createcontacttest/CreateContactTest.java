package com.crm.createcontacttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseTest.BaseClass;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.objectrepositoryutility.ContactInfoPage;
import com.crm.generic.objectrepositoryutility.CreateContactPage;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.objectrepositoryutility.OrgInfoPage;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.webdriverutility.WebDriverUtility;

@Listeners(com.crm.listenerUtility.ListImpClass.class)

public class CreateContactTest extends BaseClass{

	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	
	@Test
	public void createContactTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		
		HomePage homePage = new HomePage(UtilityClassObject.getDriver());
		homePage.getContactLink().click();
		
		CreateContactPage ccp = new CreateContactPage(UtilityClassObject.getDriver());
		ccp.getPlusIcon().click();
		ccp.getLastName().sendKeys(lastName);
		ccp.getSaveButton().click();
		
		ContactInfoPage cp = new ContactInfoPage(UtilityClassObject.getDriver());
		String headerinfo = cp.getHeaderInfo().getText();
		Assert.assertEquals(true,headerinfo.contains(lastName));
		String actLastName = cp.getLastNameInfo().getText();
		Assert.assertEquals(actLastName,lastName);
		
	}
	
	public void modifyContactTest() throws Throwable {
	
		System.out.println("execute modifyContactTest");
	}
}
