package com.realbucks.test.stepsdefine;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import com.realbucks.test.stepsmodules.RealBucks_RegisterPage_Modules;
import net.thucydides.core.annotations.Steps;

public class RealBucksTestSteps {
	@Steps
	RealBucks_RegisterPage_Modules realbucks_registerpage_modules;

	@Then("I should see the text inside the text box")
	public void thenIShouldSeeTheTextInsideTheTextBox() {
		realbucks_registerpage_modules.verifyenteredtext();
	}

	@Then("I verify the menu values")
	public void thenIVerifyTheMenuValues() {
		realbucks_registerpage_modules.verifyMenuSets();
	}

	@Given("I click on the text box")
	public void givenIClickOnTheTextBox() {
		realbucks_registerpage_modules.clickOntextbox();
	}

	@When("I enter my text")
	public void whenIEnterMyText() {
		realbucks_registerpage_modules.entertext();
	}

	@Then("I click on menu button")
	public void thenIClickOnMenuButton() {
		realbucks_registerpage_modules.ClickMenuBtn();
	}
}