package com.serenityjbehave.grid.PageObject;

public class PCHregisterPagePageObject extends MyPageObjects {

	public void ClickOnTheRegistrationButton() {
		register_btn.waitUntilClickable().click();
	}

	public void IShouldPresentInRegistrationPage() {

		reg_submit_btn.waitUntilClickable();
	
		
		
	}

}
