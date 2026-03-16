package com.crm.generic.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriver driver;

	WebDriverUtility wlib = new WebDriverUtility();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement logOut;

	@FindBy(xpath = "//td[@class='small']/img[contains(@src,'user')]")
	private WebElement profile;

	@FindAll({ @FindBy(linkText = "Organizations"), @FindBy(xpath = "//a[contains(text(),'Organizations')]") })
	private WebElement orgLink;

	@FindAll({ @FindBy(linkText = "Contacts"), @FindBy(xpath = "//a[contains(text(),'Contacts')]") })
	private WebElement contactLink;

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void logout() {
		wlib.moveMouseOnElement(driver, getProfile());
		getLogOut().click();
	}

}
