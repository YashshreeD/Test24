package base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\yashs\\Documents\\Testing\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\yashs\\Desktop\\myjava\\geckodriver-v0.34.0-win32\\geckodriver.exe");
       
        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
       FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        
        WebDriver driver = new FirefoxDriver(firefoxOptions);  
        driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "");
  		WebDriver driver = new EdgeDriver();
    		driver.manage().window().maximize();
		return driver;
	}
}
