package pageRepositories;

import static org.testng.Assert.assertTrue;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class HomePage {

	private WebDriver driver;
	
	//===================== ELEMENTS====================//
	
	@FindBy(xpath="//a[text()='Demos' and @href='https://jqueryui.com/demos/']")
	private WebElement demos;
	
	@FindBy(xpath="//h3[@class='widget-title' and text()='Widgets']//following::a[@href='https://jqueryui.com/controlgroup/']")
	private WebElement controlGroups;
	
	
	//==================== METHODS ==============================//
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	 PageFactory.initElements(driver,this);
	}
	
	public void fn_verifyjQueryHomePageLoaded() {
		assertTrue(Library.fn_haspageLoaded(driver), "Page load : timed out");
	}
	
	public DemosPage fn_clickOnDemos() {
		if(Library.fn_isElementPresent(demos, driver)) {
			demos.click();
			return new DemosPage(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",demos));
	}
	
	public ControlGroupPage fn_clickOnControlGroup() {
		if(Library.fn_isElementPresent(controlGroups, driver)) {
			controlGroups.click();
			return new ControlGroupPage(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",controlGroups));
	}
	
	
	
}
