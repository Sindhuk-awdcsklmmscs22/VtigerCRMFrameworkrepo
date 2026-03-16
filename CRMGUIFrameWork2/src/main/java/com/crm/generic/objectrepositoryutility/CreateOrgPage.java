package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgPage {
	
	WebDriver driver;
	WebDriverUtility wlib = new WebDriverUtility();

	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement plusIcon;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName_tf;

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shippingAdd;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industrydp;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typedp;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumber;

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getOrgName_tf() {
		return orgName_tf;
	}

	public WebElement getShippingAdd() {
		return shippingAdd;
	}

	public WebElement getIndustrydp() {
		return industrydp;
	}

	public WebElement getTypedp() {
		return typedp;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void selectIndustry(String text) {
		wlib.waitForElementToBeClickable(driver, industrydp);
		wlib.selectDp(industrydp, text);
	}
	
	public void selectType(String text) {
		wlib.waitForElementToBeClickable(driver, typedp);
		wlib.selectDp(typedp, text);
	}

}
