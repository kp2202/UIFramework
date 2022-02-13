package driverServices;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import library.GlobalVariables;
import lombok.Synchronized;

public class DriverService {

	private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

	public WebDriver setDriver(String browser) {
		//String browser="CHROME"; // get the value from cmd line 
		switch(browser) {
		case "CHROME":{
			System.setProperty("webdriver.chrome.driver",GlobalVariables.CHROME_DRIVER_PATH);
			webdriver.set(new ChromeDriver((ChromeOptions)BrowserCapabilities.getOptions(browser)));
			System.out.println("Thread ID :" +Thread.currentThread().getName());
			break;
		}
		case "FIREFOX":{
			System.setProperty("webdriver.gecko.driver",GlobalVariables.FIREFOX_DRIVER_PATH);
			webdriver.set(new FirefoxDriver((FirefoxOptions)BrowserCapabilities.getOptions(browser)));
			break;
		}
		case "IE":{
			System.setProperty("driver.ie.driver",GlobalVariables.IE_DRIVER_PATH);
			webdriver.set(new InternetExplorerDriver((InternetExplorerOptions)BrowserCapabilities.getOptions(browser)));
			break;
		}
		default: 
			throw new  RuntimeException(MessageFormat.format("The Browser[{0}] is either invalid or not compatible with the application", browser));
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	 return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		//setDriver();
		return webdriver.get();
	}

	public void quitDriver() {
		webdriver.remove();
	}




}
