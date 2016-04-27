package com.serenityjbehave.grid.Steps;

import com.serenityjbehave.grid.PageObject.PCHregisterPagePageObject;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

public class PCHregisterPageSteps {
	
	@ManagedPages
	PCHregisterPagePageObject pchregisterpagepageobject;

	@Step
	public void openURL() {
		pchregisterpagepageobject.open();
	}

	@Step
	public void ClickOnTheRegistrationButton() {
		pchregisterpagepageobject.ClickOnTheRegistrationButton();	
	}

	@Step
	public void IShouldPresentInRegistrationPage() {
		pchregisterpagepageobject.IShouldPresentInRegistrationPage();
	}

}
