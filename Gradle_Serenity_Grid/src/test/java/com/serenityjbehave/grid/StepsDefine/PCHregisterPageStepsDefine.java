package com.serenityjbehave.grid.StepsDefine;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

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
	@Aliases(values = { "I log to PCH website", "I am navigating to PCH website" })
	public void givenIGoToPCHWebsite() {
		pchregisterpagesteps.openURL();
	}

	@Given("I type and go to $site")
	public void givenIgoToSite(@Named("site") String site) {
		pchregisterpagesteps.openURL(site);
	}

	@Then("I click on the registration submit button")
	public void thenIClickOnTheRegistrationSubmitButton() {
	}

	@Then("I click on file upload button")
	public void thenIclickonfileuploadbutton() {
		pchregisterpagesteps.clickUploadButton();
	}
	
	@When("I click on file upload button")
	public void whenIClickOnFileUploadButton() {
		pchregisterpagesteps.clickUploadButton();
	}

	@Then("I apply AutoIT to it")
	public void thenIapplyAutoITtoit() {
		pchregisterpagesteps.applyAutoITscript();
	}

	@Then("Verify the file is uploaded")
	public void thenVerifythefileisuploaded() {
		pchregisterpagesteps.Verifythefileisuploaded();
	}

	@Then("I should present in registration page")
	public void thenIShouldPresentInRegistrationPage() {
		pchregisterpagesteps.IShouldPresentInRegistrationPage();
	}

	@Then("Assert for fail")
	public void thenAssertforfail() {
		Assert.assertEquals(0, 1);
	}

	@Then("Verify the registration page validation error message is withour first and last name")
	public void thenVerifyTheRegistrationPageValidationErrorMessageIsWithourFirstAndLastName() {
	}

	@Then("I wait for $time seconds")
	public void Iwaitfortimeseconds(@Named("time") int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}