package stepDefinitions;

import static org.testng.Assert.assertTrue;

import driverServices.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageRepositories.DemosPage;
import pageRepositories.Draggable;
import pageRepositories.Droppable;
import pageRepositories.Resizable;
import pageRepositories.Selectable;
import pageRepositories.Sortable;

public class StepDef_DemosPage extends BaseClass{

	DemosPage demospage= new DemosPage(driver);
	Draggable draggable;
	Droppable droppable;
	Resizable resizable;
	Selectable selectable;
	Sortable sortable;

	@Given("User clicks on draggable hyperlink")
	public void user_clicks_on_draggable_hyperlink() {
		demospage.fn_verifyDemospageLoaded();
		draggable=demospage.fn_clickOn_Draggable();
	}

	@Then("User is redirected to draggable page")
	public void user_is_redirected_to_draggable_page() {
		assertTrue(draggable.fn_verifyDraggablePageLoaded(),"Draggable page did not load in time");
	}

	@Given("User clicks on droppable hyperlink")
	public void user_clicks_on_droppable_hyperlink() {
		demospage.fn_verifyDemospageLoaded();
		droppable=demospage.fn_clickOn_Droppable();
	}

	@Then("User is redirected to droppable page")
	public void user_is_redirected_to_droppable_page() {
		assertTrue(droppable.fn_verifyDroppablePageLoaded(),"Droppable page did not load in time");
	}

	@Given("User clicks on selectable hyperlink")
	public void user_clicks_on_selectable_hyperlink() {
		demospage.fn_verifyDemospageLoaded();
		selectable=demospage.fn_clickOn_Selectable();
	}

	@Then("User is redirected to selectable page")
	public void user_is_redirected_to_selectable_page() {
		assertTrue(selectable.fn_verifySelectablePageLoaded(),"Selectable page did not load in time");
	}

	@Given("User clicks on resizable hyperlink")
	public void user_clicks_on_resizable_hyperlink() {
		demospage.fn_verifyDemospageLoaded();
		resizable=demospage.fn_clickOn_Resizable();

	}
	@Then("User is redirected to resizable page")
	public void user_is_redirected_to_resizable_page() throws InterruptedException {
		assertTrue(resizable.fn_verifyResizablePageLoaded(),"Resizable page did not load in time");
	}

	@Given("User clicks on sortable hyperlink")
	public void user_clicks_on_sortable_hyperlink() {
		demospage.fn_verifyDemospageLoaded();
		sortable=demospage.fn_clickOn_Sortable();

	}
	
	@Then("User is redirected to sortable page")
	public void user_is_redirected_to_sortable_page() {
		assertTrue(sortable.fn_verifySortablePageLoaded(),"Sortable page did not load in time");
	}

}
