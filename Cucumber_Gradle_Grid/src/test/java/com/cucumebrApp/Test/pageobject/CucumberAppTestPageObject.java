package com.cucumebrApp.Test.pageobject;

import net.serenitybdd.core.pages.PageObject;

public class CucumberAppTestPageObject extends PageObject {

	public void i_go_to(String site) {
		System.out.println(site);
		setDefaultBaseUrl(site);
	}

	public void observer_the_search_bar_is_present() {
		System.out.println("^observer the search bar is present$");
	}

	public void i_type_in_the_search_bar(String search) {
		System.out.println(search);
	}

	public void i_hit_enter() {
		System.out.println("^I hit enter$");
	}

	public void i_validate_the_the_page_title(String title) {
		System.out.println(title);
	}

	public void i_check_result_count() {
		System.out.println("^I check for the number of counts of the link in that page$");
	}

	public void i_want_to_write_a_step_with(String arg1) {
		System.out.println(arg1);
	}

	public void i_check_for_the_in_step(String arg1) {
		System.out.println(arg1);
	}

	public void i_verify_the_success_in_step(String status) {
		System.out.println(status);
	}

}
