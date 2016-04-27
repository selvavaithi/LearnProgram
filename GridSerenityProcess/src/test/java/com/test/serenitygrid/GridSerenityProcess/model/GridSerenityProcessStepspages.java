package com.test.serenitygrid.GridSerenityProcess.model;

import com.test.serenitygrid.GridSerenityProcess.pageobject.GridSerenityProcesspageObject;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

public class GridSerenityProcessStepspages {

	@ManagedPages
	GridSerenityProcesspageObject gridserenityprocesspageobject;

	@Step
	public void openPCHurl() {
		gridserenityprocesspageobject.open();
	}

	@Step
	public void clickOnRegisterButton() {
		// gridserenityprocesspageobject.clickRegisterBtn();
	}

	@Step
	public void verifyPageIsRegistration() {
		// gridserenityprocesspageobject.verifyRegisterpage();

	}

	@Step
	public void clickRegisterSubmitBtn() {
		// gridserenityprocesspageobject.click_register_submit_btn();

	}

	@Step
	public void VerifyRegisterPageErrorMessgae() {
		// gridserenityprocesspageobject.verify_register_validation_error_msg();
	}

	@Step
	public void EnterFNandLN(String myfirstname, String mylastname) {
		// gridserenityprocesspageobject.enterFirstName(myfirstname);
		// gridserenityprocesspageobject.enterLastName(mylastname);
	}

	@Step
	public void Isearchnearbyplacethatarenearplaces(String nearbyplace, String place) {
		gridserenityprocesspageobject.getGeocodingfor(place);
		gridserenityprocesspageobject.getNearByPlacesFor(nearbyplace);
	}

}
