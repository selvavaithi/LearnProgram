package com.cucumebrApp.Test.models;

import com.cucumebrApp.Test.pageobject.CucumberAppTestPageObject;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

public class CucumberAppTestStepsModel {

	@ManagedPages
	CucumberAppTestPageObject cucumberapptestpageobject;

	@Step
	public void i_go_to(String site) {
		cucumberapptestpageobject.i_go_to(site);
	}

	@Step
	public void observer_the_search_bar_is_present() {
		cucumberapptestpageobject. observer_the_search_bar_is_present();
	}

	@Step
	public void i_type_in_the_search_bar(String search) {
		cucumberapptestpageobject.i_type_in_the_search_bar(search);
	}

	@Step
	public void i_hit_enter() {
		cucumberapptestpageobject.i_hit_enter();
	}

	@Step
	public void i_validate_that_the_page_title(String title) {
		cucumberapptestpageobject.i_validate_that_the_page_title(title);
	}

	@Step
	public void i_check_result_count() {
		cucumberapptestpageobject.i_check_result_count();
	}

	@Step
	public void i_want_to_write_a_step_with(String arg1) {
		cucumberapptestpageobject.i_want_to_write_a_step_with(arg1);
	}

	@Step
	public void i_check_for_the_in_step(String arg1) {
		cucumberapptestpageobject.i_check_for_the_in_step(arg1);
	}

	@Step
	public void i_verify_the_success_in_step(String status) {
		cucumberapptestpageobject.i_verify_the_success_in_step(status);
	}

}
