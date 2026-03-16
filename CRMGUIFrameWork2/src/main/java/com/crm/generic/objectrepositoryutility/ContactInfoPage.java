package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;

	@FindBy(xpath = "//span[@class='dtlview_Last Name']")
	private WebElement lastNameInfo;

	@FindBy(xpath = "//span[@class='dtlview_Support Start Date']")
	private WebElement supportStartDateInfo;

	@FindBy(xpath = "//span[@class='dtlview_Support End Date']")
	private WebElement supportEndtDateInfo;

	public WebElement orgNameInfo(WebDriver driver, String orgname) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + orgname + "')]"));
	}

	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}

	public WebElement getSupportStartDateInfo() {
		return supportStartDateInfo;
	}

	public WebElement getSupportEndtDateInfo() {
		return supportEndtDateInfo;
	}

}
