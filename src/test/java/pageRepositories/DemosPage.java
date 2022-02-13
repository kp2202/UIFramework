package pageRepositories;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import library.Library;

public class DemosPage {
	public WebDriver driver;

	// ==================== WEBELEMENTS =======================//
	@FindBy(xpath="//h1[text()='jQuery UI Demos']")
	private WebElement demos_title;

	@FindBy(xpath="//div[@id='content']//descendant::a[@href='https://jqueryui.com/draggable/' and text()='Draggable']")
	private WebElement draggable;

	@FindBy(xpath="//div[@id='content']//descendant::a[@href='https://jqueryui.com/droppable/' and text()='Droppable']")
	private WebElement droppable;

	@FindBy(xpath="//div[@id='content']//descendant::a[@href='https://jqueryui.com/resizable/' and text()='Resizable']")
	private WebElement resizable;

	@FindBy(xpath="//div[@id='content']//descendant::a[@href='https://jqueryui.com/selectable/' and text()='Selectable']")
	private WebElement selectable;

	@FindBy(xpath="//div[@id='content']//descendant::a[@href='https://jqueryui.com/sortable/' and text()='Sortable']")
	private WebElement sortable;
	//======================== METHODS =======================//

	public DemosPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public Boolean fn_verifyDemospageLoaded() {

		if(Library.fn_haspageLoaded(driver)) {
			if(Library.fn_isElementPresent(demos_title, driver)) {
				return true; 

			}else
				return false;
		}
		return false;
	}


	public Draggable fn_clickOn_Draggable() {
		if(Library.fn_haspageLoaded(driver)) {
			draggable.click();
			return new Draggable(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",draggable));
	}

	public Droppable fn_clickOn_Droppable() {
		if(Library.fn_haspageLoaded(driver)) {
			droppable.click();
			return new Droppable(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",droppable));
	}

	public Resizable fn_clickOn_Resizable() {
		if(Library.fn_haspageLoaded(driver)) {
			resizable.click();
			return new Resizable(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",resizable));
	}

	public Selectable fn_clickOn_Selectable() {
		if(Library.fn_haspageLoaded(driver)) {
			selectable.click();
			return new Selectable(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",selectable));
	}

	public Sortable fn_clickOn_Sortable() {
		if(Library.fn_haspageLoaded(driver)) {
			sortable.click();
			return new Sortable(driver);
		}else throw new RuntimeException(MessageFormat.format("The WebElement [{0}] is inactive or not available",sortable));
	}
}
