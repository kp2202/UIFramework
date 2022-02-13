package pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class Selectable {

	public WebDriver driver;
	//********************** WEBELEMENTS **********************//
	@FindBy(xpath="//h1[@class='entry-title' and text()='Selectable']")
	private WebElement selectable_title;
	
	
	
	
	
	
	
	
	
	
	
	
	//********************** METHODS ************************//
	public Selectable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean fn_verifySelectablePageLoaded() {

		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(selectable_title, driver)) {
				return true; 
			}else
				return false;
		}
		return false;
	}
	
	
	
	
	
}
