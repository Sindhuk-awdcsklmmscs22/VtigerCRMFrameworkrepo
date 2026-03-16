package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {

	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// this.driver = driver;
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgInfo;

	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement industryInfo;

	@FindBy(xpath = "//span[@id='dtlview_Type']")
	private WebElement typeInfo;

	@FindBy(xpath = "//span[@id='dtlview_Phone']")
	private WebElement phoneNumInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getTypeInfo() {
		return typeInfo;
	}

	public WebElement getPhoneNumInfo() {
		return phoneNumInfo;
	}

}
