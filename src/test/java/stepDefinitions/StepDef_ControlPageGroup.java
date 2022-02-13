package stepDefinitions;

import driverServices.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import library.Library;
import pageRepositories.ControlGroupPage;
import pageRepositories.HomePage;

public class StepDef_ControlPageGroup extends BaseClass {

	private TestContext testcontext;

	ControlGroupPage controlgroup;

	public StepDef_ControlPageGroup(TestContext testcontext) {
		this.testcontext=testcontext;
	}

	/*
	 * @Given("User selects rental car as {string}") public void
	 * user_selects_rental_car_as(String carType) { controlgroup= new
	 * ControlGroupPage(driver); controlgroup.fn_moveToFrame();
	 * controlgroup.fn_selectfromDropdwn(carType); }
	 * 
	 * @Given("User selects car transmission as {string}") public void
	 * user_selects_car_transmission_as(String carTransmission) {
	 * controlgroup.fn_selectRadioButton(carTransmission); }
	 * 
	 * @Given("User selects car insurance") public void user_selects_car_insurance()
	 * { controlgroup.fn_selectInsurance(); }
	 * 
	 * @Given("User selects {int} as number of cars") public void
	 * user_selects_as_number_of_cars(int NumberOfCars) {
	 * controlgroup.fn_selectNoOfCars(NumberOfCars); }
	 * 
	 * @Then("User clicks on book now.") public void user_clicks_on_book_now() {
	 * controlgroup.fn_clickBookNow(); }
	 */
}
