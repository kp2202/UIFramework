package pageRepositories;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Library;

public class ControlGroupPage {
	private WebDriver driver;

	//******************** WEB ELEMENTS ****************//
	@FindBy(xpath="//div[@id='content']//following::h1[text()='Controlgroup'] ")
	private WebElement controlGroup_title;

	@FindBy(xpath="//iframe[@class='demo-frame']")
	private WebElement controlgroup_iframe;

	@FindBy(xpath="//span[@class='ui-selectmenu-button ui-button ui-widget ui-controlgroup-item ui-selectmenu-button-closed ui-corner-left']")
	private WebElement car_type;
	
	@FindBy(xpath="//div[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']")
	private WebElement car_type_combo_tray;

	@FindBy(xpath="//label[@for='transmission-standard']")
	private WebElement standard;

	@FindBy(xpath="//label[@for='transmission-automatic']")
	private WebElement automatic;

	@FindBy(xpath="//label[@for='insurance']")
	private WebElement insurance;

	@FindBy(id="horizontal-spinner")
	private WebElement NoOfCars;
	
	@FindBy(xpath="//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//following-sibling::a[@class='ui-button ui-widget ui-spinner-button ui-button-icon-only ui-spinner-up']")
	private WebElement spinner_up;

	@FindBy(xpath="//div[@class='controlgroup ui-controlgroup ui-controlgroup-horizontal ui-helper-clearfix']//following-sibling::a[@class='ui-button ui-widget ui-spinner-button ui-button-icon-only ui-spinner-down']")
	private WebElement spinner_down;
	
	@FindBy(xpath="//button[@class='ui-widget ui-controlgroup-item ui-button ui-corner-right' and text()='Book Now!']")
	private WebElement bookNow;

	//********************** METHODS ****************************//

	public ControlGroupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void fn_moveToFrame() {
		if(Library.fn_isElementPresent(controlgroup_iframe, driver)) {
			Library.switch_To_Frame(driver, controlgroup_iframe);
		}
	}


	public boolean fn_verifyControlGroupPageLoaded() {
		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(controlGroup_title, driver) && Library.fn_isElementPresent(controlgroup_iframe, driver)) {
				return true; 

			}else
				return false;
		}
		return false;
	}

	public void fn_selectfromDropdwn(String val) {
		if(Library.fn_isElementPresent(car_type, driver)) {
			car_type.click();
			if(Library.fn_isElementPresent(car_type_combo_tray, driver)) {
				List<WebElement> options=driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
				 for(WebElement e: options) {
					 if(e.getText().equalsIgnoreCase(val)){
						 e.click();
					 }
				 }
			}
		}else throw new RuntimeException(MessageFormat.format("The expected combo box [{0}] is not present ",car_type));
	}

	public void fn_selectRadioButton(String carTransmission) {
		if(carTransmission.equalsIgnoreCase(standard.getText())) {
			standard.click();
		}else
			automatic.click();
	}

	public void fn_selectInsurance() {
		if(Library.fn_isElementPresent(insurance, driver)) {
			insurance.click();
		}else throw new RuntimeException(MessageFormat.format("The Given Element [{0}] is not available or clickable",insurance));
	}

	public void fn_selectNoOfCars(int number) {
		if(Library.fn_isElementPresent(NoOfCars, driver)) {
			if (number>0) {
				for(int i=0;i<number;i++) {
					spinner_up.click();
				}
			}else {
				for(int i=0;i<number;i++) {
					spinner_down.click();
				}
			}
		}
	}
	
	public void fn_clickBookNow() {
		if(Library.fn_isElementPresent(bookNow, driver)) {
			bookNow.click();
		}else
			throw new RuntimeException(MessageFormat.format("The Web element [{0}] is not available or not clickable", bookNow));
		
	}
}
