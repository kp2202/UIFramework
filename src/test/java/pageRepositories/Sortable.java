package pageRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class Sortable {

	public WebDriver driver;
	//********************** WEBELEMENTS **********************//
	@FindBy(xpath="//h1[@class='entry-title' and text()='Sortable']")
	private WebElement sortable_title;
	
	
	
	
	
	
	
	
	
	
	
	
	//********************** METHODS ************************//
	public Sortable(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean fn_verifySortablePageLoaded() {

		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(sortable_title, driver)) {
				return true; 
			}else
				return false;
		}
		return false;
	}
	
	
	
	
	
}
