package driverServices;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserCapabilities {

	public static  MutableCapabilities getOptions(String browser) {
		List<String> optionList= Arrays.asList(
				"--start-maximized",
				"--disable-popup-blocking",
				"--disable-infobars",
				"--disable-extensions"
				);

		switch(browser) {
		case "CHROME":{
			ChromeOptions chOptions= new ChromeOptions();
			chOptions.addArguments(optionList);
			return chOptions;

		}

		case "FIREFOX":{
			FirefoxOptions fxoption= new FirefoxOptions();
			fxoption.addArguments(optionList);
			return fxoption;
		}
		}
		return null;



	}

}
