package driverServices;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	protected WebDriver driver;
	public BaseClass() {
		
		driver= DriverService.getDriver();

	}
	


}
