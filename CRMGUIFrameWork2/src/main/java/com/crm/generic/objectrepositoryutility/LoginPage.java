package com.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({@FindBy(name="user_name"), @FindBy(xpath="//input[@type='text']"),@FindBy(xpath="//input[@type='user_name']")})
	private WebElement username;
	
	@FindAll({@FindBy(name="user_password"), @FindBy(xpath="//input[@type='password']"),@FindBy(xpath="//input[@type='user_password']")})
	private WebElement password;
	
	@FindAll({@FindBy(xpath="//input[@type='submit']"), @FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String username, String password) {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();;
	}
	
}
