package com.serenityjbehave.grid.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyPageObjects extends PageObject {

	@FindBy(id = "EM")
	WebElementFacade emailID;

	@FindBy(id = "PW")
	WebElementFacade userpwd;

	@FindBy(css = "a.sign-in.link-button")
	WebElementFacade sign_in;

	@FindBy(css = "a.registration.register-btn")
	WebElementFacade register_btn;

	@FindBy(css = "a#login-sub-btn")
	WebElementFacade btn_sign_in;

	@FindBy(css = "input#sub-btn.submit-btn")
	WebElementFacade reg_submit_btn;
	
	@FindBy(css = "span.btn.btn-success.fileinput-button")
	WebElementFacade Add_files_btn;
}
