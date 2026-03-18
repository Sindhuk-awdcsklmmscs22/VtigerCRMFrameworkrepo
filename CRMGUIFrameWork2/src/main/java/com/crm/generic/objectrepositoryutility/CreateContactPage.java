package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactPage {
	
	WebDriver driver;
	//WebDriverUtility wlib = new WebDriverUtility();

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement plusIcon;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement supportEndDate;

	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement supportStartDate;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgName;

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchTF;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement selectOrg(WebDriver driver, String orgname) {
		return driver.findElement(By.xpath("//a[contains(text(),'" + orgname + "')]"));
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

}
