package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = ("//input[@name='txtUsername']"))
	private WebElement userName;
	 
	@FindBy(xpath = ("//input[@name='txtPassword']"))
	private WebElement pass;
	
	@FindBy(xpath = ("//button[@type='submit']"))
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String user){
		userName.sendKeys(user);
	}
	public void sendPassWord(String password){
		pass.sendKeys(password);
	}
	public void clickOnLoginButton(){
		loginButton.click();
	}
	public void varifyLoginPageTitle() {
		
	}
}
