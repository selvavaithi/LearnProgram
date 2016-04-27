package com.test.serenitygrid.GridSerenityProcess.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.test.serenitygrid.GridSerenityProcess.model.GridSerenityProcessStepspages;

import net.thucydides.core.annotations.Steps;

public class GridSerenityProcessSteps {

	@Steps
	GridSerenityProcessStepspages gridserenityprocesspages;

	@Given("I go to PCH website")
	public void givenIGoToPCHWebsite() {
		gridserenityprocesspages.openPCHurl();
	}

	@When("I click on the registration button")
	public void whenIClickOnTheRegistrationButton() {
		gridserenityprocesspages.clickOnRegisterButton();
	}

	@Then("I should present in registration page")
	public void thenIShouldPresentInRegistrationPage() {
		gridserenityprocesspages.verifyPageIsRegistration();
	}

	@Then("I click on the registration submit button")
	public void thenIClickOnTheRegistrationSubmitButton() {
		gridserenityprocesspages.clickRegisterSubmitBtn();
	}

	@Then("Verify the registration page validation error message")
	public void thenVerifyTheRegistrationPageValidationErrorMessage() {
		gridserenityprocesspages.VerifyRegisterPageErrorMessgae();
	}

	@Then("I enter value for first and last name as $myfirstname and $mylastname respectively")
	public void thenIEnterValueForFirstAndLastName(String myfirstname, String mylastname) {
		gridserenityprocesspages.EnterFNandLN(myfirstname, mylastname);
	}

	@Then("Verify the registration page validation error message is withour first and last name")
	public void thenVerifyTheRegistrationPageValidationErrorMessageIsWithourFirstAndLastName() {
	}

	@Then("I search $nearbyplace that are near $place")
	public void ThenIsearchnearbyplacethatarenearplaces(@Named("nearbyplace") String nearbyplace,
			@Named("place") String place) {

		gridserenityprocesspages.Isearchnearbyplacethatarenearplaces(nearbyplace, place);

	}

}
