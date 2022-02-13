package pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class Draggable {

	public WebDriver driver;
	//********************** WEBELEMENTS **********************//
	@FindBy(xpath="//h1[@class='entry-title' and text()='Draggable']")
	private WebElement draggable_title;
	
	
	
	
	
	
	
	
	
	
	
	
	//********************** METHODS ************************//
	public Draggable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean fn_verifyDraggablePageLoaded() {

		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(draggable_title, driver)) {
				return true; 
			}else
				return false;
		}
		return false;
	}
	
	
	
	
	
}
