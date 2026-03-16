package com.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseTest.BaseClass;
import com.crm.generic.fileutility.ExcelUtility;
import com.crm.generic.objectrepositoryutility.CreateOrgPage;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.objectrepositoryutility.OrgInfoPage;
import com.crm.generic.webdriverutility.JavaUtility;
import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.webdriverutility.WebDriverUtility;

@Listeners(com.crm.listenerUtility.ListImpClass.class)

public class CreateOrgTest extends BaseClass {

	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();

	@Test
	public void createOrgTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		String shipAdd = elib.getDataFromExcel("org", 1, 3);

		//
		UtilityClassObject.getTest().log(Status.INFO, "click on org link");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		CreateOrgPage cp = new CreateOrgPage(driver);
		cp.getPlusIcon().click();
		
		//
		cp.getOrgName_tf().sendKeys(orgName);
		cp.getShippingAdd().sendKeys(shipAdd);
		
		//
		UtilityClassObject.getTest().log(Status.INFO, "create new org");
		cp.getSaveButton().click();
		
		OrgInfoPage op = new OrgInfoPage(driver);
		String headerinfo = op.getHeaderInfo().getText();
		Assert.assertEquals(true,headerinfo.contains(orgName));
		String actOrgName = op.getOrgInfo().getText();
		Assert.assertEquals(actOrgName,orgName);
	}

	@Test
	public void createOrgWithIndustryTypeTest() throws Throwable {
			HomePage hp = new HomePage(driver);
			CreateOrgPage cp = new CreateOrgPage(driver);
			OrgInfoPage op = new OrgInfoPage(driver);
			
			String orgName = elib.getDataFromExcel("org", 4, 2)+jlib.getRandomNumber();
			String shipAdd = elib.getDataFromExcel("org", 4, 3);
			String industryName = elib.getDataFromExcel("org", 4, 4);
			String typeName = elib.getDataFromExcel("org", 4, 5);
			
			hp.getOrgLink().click();
			cp.getPlusIcon().click();
			cp.getOrgName_tf().sendKeys(orgName);
			cp.getShippingAdd().sendKeys(shipAdd);
			cp.selectIndustry(industryName);
			cp.selectType(typeName);
			cp.getSaveButton().click();
			
			String headerinfo = op.getHeaderInfo().getText();
			Assert.assertEquals(true,headerinfo.contains(orgName));
			String actIndustry = op.getIndustryInfo().getText();
			Assert.assertEquals(actIndustry,industryName);
			String actType = op.getTypeInfo().getText();
			Assert.assertEquals(actType,typeName);
		}
	
	@Test
	public void createOrgTestWithPhoneNumber() throws Throwable {

		HomePage hp = new HomePage(driver);
		CreateOrgPage cp = new CreateOrgPage(driver);
		OrgInfoPage op = new OrgInfoPage(driver);

		
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String shipAdd = elib.getDataFromExcel("org", 7, 3);
		String phNumber = elib.getDataFromExcel("org", 7, 4);

		hp.getOrgLink().click();
		cp.getPlusIcon().click();
		cp.getOrgName_tf().sendKeys(orgName);
		cp.getShippingAdd().sendKeys(shipAdd);
		cp.getPhoneNumber().sendKeys(phNumber);
		cp.getSaveButton().click();
		
		String headerinfo = op.getHeaderInfo().getText();
		//Intentional failing stt 
		Assert.assertFalse(headerinfo.contains(orgName));
		//Assert.assertEquals(true,headerinfo.contains(orgName));
		String actPhoneNumber = op.getPhoneNumInfo().getText();
		Assert.assertEquals(actPhoneNumber,phNumber);
	}

}
