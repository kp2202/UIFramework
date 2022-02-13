package hooks;

import java.io.File;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverServices.BaseClass;
import driverServices.DriverService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import library.GlobalVariables;




public class CucumberHooks extends BaseClass {

	private DriverService driverService;
	private WebDriver driver;



	@Before(order=1)
	public void init() throws InterruptedException {
		String browser=System.getProperty("Browser");
		if(browser==null) {
			browser="CHROME";
		}
		driverService= new DriverService();
		driver=driverService.setDriver(browser);
		DriverService.getDriver().get(GlobalVariables.APP_URL);
		//Thread.sleep(2000);


	}

	@After(order=0)
	public void quit() {
		driver.quit();
	}


	@After(order=1)
	public void getProperty() throws ConfigurationException {
		//update extent.properties
		File propertiesFile = new File("src/test/resources/extent.properties");      
		PropertiesConfiguration config = new PropertiesConfiguration(propertiesFile);        
		config.setProperty("extent.reporter.spark.out",GlobalVariables.EXTENT_SPARK_REPORT_PATH+library.Util.returnCurrentDateTime()+".html");
		config.save();
	}

	@After(order=2)
	public void takeScreenshotOnFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName=scenario.getName().replaceAll(" ","_");
			String srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			scenario.attach(srcPath, "image/png", screenshotName);
		}
	}



}

