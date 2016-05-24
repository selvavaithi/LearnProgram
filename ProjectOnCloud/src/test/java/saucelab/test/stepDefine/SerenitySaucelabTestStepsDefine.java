package saucelab.test.stepDefine;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import saucelab.test.stepModule.SerenitySaucelabTest_StepsModule;

public class SerenitySaucelabTestStepsDefine {

	@Steps
	SerenitySaucelabTest_StepsModule serenitysaucelabTest_stepsmodule;

	@Then("I fill the registration page detail")
	public void thenIFillTheRegistrationPageDetail() {
		serenitysaucelabTest_stepsmodule.fillRegistrationPage();
	}

	@Given("I verify the home page of the app")
	public void givenIVerifyTheHomePageOfTheApp() {
		serenitysaucelabTest_stepsmodule.verifyAppHomePage();
	}

	@Given("I verify the registration page of the app")
	public void givenIVerifyTheRegistrationPageOfTheApp() {
		serenitysaucelabTest_stepsmodule.verifyAppRegistrationPage();
	}

	@Then("I verify the registration page of the app")
	public void thenIVerifyTheRegistrationPageOfTheApp() {
		serenitysaucelabTest_stepsmodule.verifyAppRegistrationPage();
	}

	@When("I click on Start Registration button")
	public void whenIClickOnStartRegistrationButton() {
		serenitysaucelabTest_stepsmodule.click_startUserRegistration();
	}
}