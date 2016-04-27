package com.serenityjbehave.grid.StepsDefine;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.serenityjbehave.grid.Steps.PCHregisterPageSteps;

import net.thucydides.core.annotations.Steps;

public class PCHregisterPageStepsDefine {
	
	@Steps
	PCHregisterPageSteps pchregisterpagesteps;
	
	@Then("I enter value for first and last name as My first name and My last name respectively")
	public void thenIEnterValueForFirstAndLastNameAsMyFirstNameAndMyLastNameRespectively() {
	}

	@When("I click on the registration button")
	public void whenIClickOnTheRegistrationButton() {
		pchregisterpagesteps.ClickOnTheRegistrationButton();
	}

	@Then("Verify the registration page validation error message")
	public void thenVerifyTheRegistrationPageValidationErrorMessage() {
	}

	@Given("I go to PCH website")
	public void givenIGoToPCHWebsite() {
		pchregisterpagesteps.openURL();
	}

	@Then("I click on the registration submit button")
	public void thenIClickOnTheRegistrationSubmitButton() {
	}

	@Then("I should present in registration page")
	public void thenIShouldPresentInRegistrationPage() {
		pchregisterpagesteps.IShouldPresentInRegistrationPage();
	}

	@Then("Verify the registration page validation error message is withour first and last name")
	public void thenVerifyTheRegistrationPageValidationErrorMessageIsWithourFirstAndLastName() {
	}
}