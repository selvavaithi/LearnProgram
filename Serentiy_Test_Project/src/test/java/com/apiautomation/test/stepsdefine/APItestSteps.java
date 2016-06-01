package com.apiautomation.test.stepsdefine;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.apiautomation.test.steps.APItestStepsModules;

import net.thucydides.core.annotations.Steps;

public class APItestSteps {
	String coordinatesforArea, coordinatesForNearBy;

	@Steps
	APItestStepsModules apiteststepsmodules;

	@Given("I search for $str in google api")
	public void givenISearchForInGoogleApi(@Named("str") String str) {
		apiteststepsmodules.getAddressOfstr(str);
	}

	@When("I search for $nearby that are near $area in google map api")
	public void whenISearchForHotelsNearSoftcrylicChennaiInGoogleApi(@Named("nearby") String nearby,
			@Named("area") String area) {
		apiteststepsmodules.getAddressofNearBy(nearby, area);
		coordinatesforArea = area;
		coordinatesForNearBy = nearby;
	}

	@Then("I print coordinates")
	public void thenIPrintCoordinates() {
		apiteststepsmodules.printNearByCoordinates(coordinatesforArea,coordinatesForNearBy);
	}
}