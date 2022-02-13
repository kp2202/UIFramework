package library;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {

	public static WebDriverWait wait;
	
	
	public static void highlightElement(WebElement element,WebDriver driver) {
        
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: MediumSeaGreen; border: 2px solid red ;");
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
        
	}
        

	public static boolean fn_isElementPresent(WebElement element, WebDriver driver) {
		wait= new WebDriverWait(driver,GlobalVariables.ELEMENT_WAIT);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
		if(element.isDisplayed() && element.isEnabled()) {
			highlightElement(element, driver);
			return true;
		}else
			return false;
	}


	public static boolean fn_haspageLoaded(WebDriver driver) {

		wait= new WebDriverWait(driver,GlobalVariables.PAGELOAD_WAIT);
		return wait.until( d-> 
		((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
	}

	public static void fn_selectFromDropdown_1(WebElement comboBox,String valueToSelect,WebDriver driver) {
		// use when tag is Select
		Select select = new Select(comboBox);
		List<WebElement> options=select.getOptions();
		for( WebElement option :options) {
			if(option.getText().equalsIgnoreCase(valueToSelect)) {
				select.selectByVisibleText(valueToSelect);
				break;
			}
		}
	}

	public static void fn_selectFromDropdown_2(WebElement comboBox,List<WebElement> elist, String valueToSelect,WebDriver driver) {
// use when tag is not Select (or is div or span)
		if(Library.fn_isElementPresent(comboBox, driver)) {
			for(WebElement e: elist) {
				if (e.getText().equalsIgnoreCase(valueToSelect)) {
					e.click();
					break;
				}else
					throw new RuntimeException(MessageFormat.format("The given dropdown list cant be detected",elist));
			}
		}
		
	}

	public static void switch_To_Frame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}




}
