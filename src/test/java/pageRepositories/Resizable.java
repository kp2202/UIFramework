package pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class Resizable {

	public WebDriver driver;
	//********************** WEBELEMENTS **********************//
	@FindBy(xpath="//h1[@class='entry-title' and text()='Resizable']")
	private WebElement resizable_title;
	
	
	
	
	
	
	
	
	
	
	
	
	//********************** METHODS ************************//
	public Resizable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean fn_verifyResizablePageLoaded() {

		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(resizable_title, driver)) {
				return true; 
			}else
				return false;
		}
		return false;
	}
	
	
	
	
	
}
