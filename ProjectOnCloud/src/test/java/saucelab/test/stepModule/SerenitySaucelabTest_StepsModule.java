package saucelab.test.stepModule;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;
import saucelab.test.pageObject.SerenitySaucelabTest_PageObject;

public class SerenitySaucelabTest_StepsModule {

	@ManagedPages
	SerenitySaucelabTest_PageObject serenitysaucelabTest_pageobject;

	@Step
	public void verifyAppHomePage() {
		serenitysaucelabTest_pageobject.verify_App_HomePage();
	}

	@Step
	public void verifyAppRegistrationPage() {
		// verify text Welcome to register a new User
		serenitysaucelabTest_pageobject.verify_App_registrationPage();
	}

	@Step
	public void fillRegistrationPage() {
		serenitysaucelabTest_pageobject.fillRegisterPage();		
	}

	@Step
	public void click_startUserRegistration() {
		// Click on register button
		serenitysaucelabTest_pageobject.click_startUserRegistration();
		
	}

}
