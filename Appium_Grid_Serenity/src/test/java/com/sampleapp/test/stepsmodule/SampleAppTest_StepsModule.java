package com.sampleapp.test.stepsmodule;

import com.sampleapp.test.pageobject.SampleAppTest_PageObject;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

public class SampleAppTest_StepsModule {

	@ManagedPages
	SampleAppTest_PageObject sampleapptest_pageobject;

	@Step
	public void verifyAppHomePage() {
		sampleapptest_pageobject.verify_App_HomePage();
	}

	@Step
	public void verifyAppRegistrationPage() {
		// verify text Welcome to register a new User
		sampleapptest_pageobject.verify_App_registrationPage();
	}

	@Step
	public void fillRegistrationPage() {
		sampleapptest_pageobject.fillRegisterPage();		
	}

	@Step
	public void click_startUserRegistration() {
		// Click on register button
		sampleapptest_pageobject.click_startUserRegistration();
		
	}

}
