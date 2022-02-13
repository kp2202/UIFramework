package pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class Droppable {

	public WebDriver driver;
	//********************** WEBELEMENTS **********************//
	@FindBy(xpath="//h1[@class='entry-title' and text()='Droppable']")
	private WebElement droppable_title;
	
	
	
	
	
	
	
	
	
	
	
	
	//********************** METHODS ************************//
	public Droppable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean fn_verifyDroppablePageLoaded() {

		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(droppable_title, driver)) {
				return true; 
			}else
				return false;
		}
		return false;
	}
	
	
	
	
	
}
