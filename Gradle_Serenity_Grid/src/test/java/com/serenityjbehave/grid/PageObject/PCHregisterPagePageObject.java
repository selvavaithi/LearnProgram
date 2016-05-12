package com.serenityjbehave.grid.PageObject;

import org.jbehave.core.annotations.AfterScenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class PCHregisterPagePageObject extends MyPageObjects {

	public void ClickOnTheRegistrationButton() {
		register_btn.waitUntilClickable().click();
	}

	public void IShouldPresentInRegistrationPage() {
		reg_submit_btn.waitUntilClickable();
	}

	@AfterScenario
	public void afterscenarioWork() {
		Sleeper.sleepTightInSeconds(3);
		((JavascriptExecutor) getDriver()).executeScript("window.onbeforeunload = function(e){};");
	}

}
