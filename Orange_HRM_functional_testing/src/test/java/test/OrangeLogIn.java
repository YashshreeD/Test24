package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pom.LoginPage;

public class OrangeLogIn extends Base {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		if (browserName.equals("Chrome"));
		{
			driver = Base.openChromeBrowser();
		}	
		if (browserName.equals("Firefox"))
		{
			driver = Base.openFirefoxBrowser();
		}
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void launchaloginPage() {
		
		driver.get("https://democrm-trials712.orangehrmlive.com/auth/login");
		loginPage = new LoginPage(driver);
		loginPage.sendUserName("Admin");
		loginPage.sendPassWord("Test@1234");
		loginPage.clickOnLoginButton();
	}
	@Test
	public void verifyLoginPageisVisible() {
		System.out.println("Test1");
		System.out.println("verify Login Page is Visible");
		String orangeTitle = driver.getTitle();
		Assert.assertEquals(orangeTitle,"Employee Management");
		
	}
	@Test
	public void verifyHomePageisVisible() {
		System.out.println("Test2");
		System.out.println("verify Home Page is Visible");
		String orangeTitle = driver.getTitle();
		Assert.assertEquals(orangeTitle,orangeTitle);
		
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
