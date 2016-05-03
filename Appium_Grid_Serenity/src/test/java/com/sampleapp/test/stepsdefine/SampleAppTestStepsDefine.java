package com.sampleapp.test.stepsdefine;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.sampleapp.test.stepsmodule.SampleAppTest_StepsModule;

import net.thucydides.core.annotations.Steps;
public class SampleAppTestStepsDefine {

	@Steps
	SampleAppTest_StepsModule sampleapptest_stepsmodule;

	@Then("I fill the registration page detail")
	public void thenIFillTheRegistrationPageDetail() {
		sampleapptest_stepsmodule.fillRegistrationPage();
	}

	@Given("I verify the home page of the app")
	public void givenIVerifyTheHomePageOfTheApp() {
		sampleapptest_stepsmodule.verifyAppHomePage();
	}

	@Given("I verify the registration page of the app")
	public void givenIVerifyTheRegistrationPageOfTheApp() {
		sampleapptest_stepsmodule.verifyAppRegistrationPage();
	}
	
	@Then("I verify the registration page of the app")
	public void thenIVerifyTheRegistrationPageOfTheApp() {
		sampleapptest_stepsmodule.verifyAppRegistrationPage();
	}

	@When("I click on Start Registration button")
	public void whenIClickOnStartRegistrationButton() {
		sampleapptest_stepsmodule.click_startUserRegistration();
	}
}