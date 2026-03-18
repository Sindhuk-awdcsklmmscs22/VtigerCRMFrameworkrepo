package com.crm.generic.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.generic.fileutility.FileUtility;
import com.crm.generic.objectrepositoryutility.HomePage;
import com.crm.generic.objectrepositoryutility.LoginPage;
import com.crm.generic.webdriverutility.UtilityClassObject;
import com.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {

	public WebDriver driver;
	FileUtility flib = new FileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	

	@BeforeSuite
	public void configBS() {
		System.out.println("connect to database");
	}

	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		UtilityClassObject.setDriver(driver);
	}

	

	@BeforeMethod
	public void configBM() throws Throwable {
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		wlib.waitForPageLoad(driver);
		driver.get(flib.getDataFromPropertiesFile("url"));
		LoginPage lp = new LoginPage(driver);
		String UN = flib.getDataFromPropertiesFile("username");
		String PWD = flib.getDataFromPropertiesFile("password");
		lp.loginToApp(UN, PWD);
	}

	@AfterMethod
	public void configAM() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		
		hp.logout();

	}
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("close connection");
	}
}
