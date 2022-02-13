package stepDefinitions;

import static org.testng.Assert.assertTrue;

import driverServices.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageRepositories.ControlGroupPage;
import pageRepositories.DemosPage;
import pageRepositories.HomePage;

public class StepDef_HomePage extends BaseClass{

 private HomePage homepage= new HomePage(driver);
 private DemosPage demospage;
 private ControlGroupPage controlgroup;
 

 

	@Given("User is on jQueryUI Home Page")
	public void user_is_on_j_query_ui_home_page() {
		homepage.fn_verifyjQueryHomePageLoaded();
	}

	@When("User clicks on demos button")
	public void user_clicks_on_demos_button() throws Exception {
	demospage=homepage.fn_clickOnDemos();
	Thread.sleep(2000);
	}

	@Then("User is redirected to Jquery UI Demos page")
	public void user_is_redirected_to_jquery_ui_demos_page() {
		assertTrue(demospage.fn_verifyDemospageLoaded(),"User did not redirect to demos page");

	}
	
	@When("User clicks on controlgroup link")
	public void user_clicks_on_controlgroup_link() {
	    controlgroup=homepage.fn_clickOnControlGroup();
	    
	}

	@Then("User is redirected to Jquery UI controlgroup page")
	public void user_is_redirected_to_jquery_ui_controlgroup_page() {
		assertTrue(controlgroup.fn_verifyControlGroupPageLoaded(),"User did not redirect to demos page");
	}

	
}
