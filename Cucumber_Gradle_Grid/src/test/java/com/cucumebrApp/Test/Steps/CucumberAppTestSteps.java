package com.cucumebrApp.Test.Steps;

import com.cucumebrApp.Test.models.CucumberAppTestStepsModel;
import com.cucumebrApp.utility.MyUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CucumberAppTestSteps {

	MyUtility myutility = new MyUtility();

	@Steps
	CucumberAppTestStepsModel cucumberappteststepsmodel;

	@Given("^I go to \"(.*)\"$")
	public void i_go_to_https_www_google_com(String site) throws Throwable {
		cucumberappteststepsmodel.i_go_to(site);
	}

	@Given("^observer the search bar is present$")
	public void observer_the_search_bar_is_present() throws Throwable {
		cucumberappteststepsmodel.observer_the_search_bar_is_present();
	}

	@When("^I type \"(.*)\" in the search bar$")
	public void i_type_testing_methodologies_in_the_search_bar(String search) throws Throwable {
		cucumberappteststepsmodel.i_type_in_the_search_bar(search);
	}

	@When("^I hit enter$")
	public void i_hit_enter() throws Throwable {
		cucumberappteststepsmodel.i_hit_enter();
	}

	@Then("^I validate that the page has \"(.*)\"$")
	public void i_validate_that_the_page_has_testing_methodologies_Google_Search(String title) throws Throwable {
		cucumberappteststepsmodel.i_validate_that_the_page_title(title);
	}

	@Then("^I check for the number of counts of the link in that page$")
	public void i_check_for_the_number_of_counts_of_the_link_in_that_page() throws Throwable {
		cucumberappteststepsmodel.i_check_result_count();
	}

	@Given("^I want to write a step with \"([^\"]*)\"$")
	public void i_want_to_write_a_step_with(String arg1) throws Throwable {
		cucumberappteststepsmodel.i_want_to_write_a_step_with(arg1);
	}

	@When("^I check for the \"([^\"]*)\" in step$")
	public void i_check_for_the_in_step(String arg1) throws Throwable {
		cucumberappteststepsmodel.i_check_for_the_in_step(arg1);
	}

	@Then("^I verify the \"(.*)\" in step$")
	public void i_verify_the_success_in_step(String status) throws Throwable {
		cucumberappteststepsmodel.i_verify_the_success_in_step(status);
	}

	@When("I wait for (\\d+) seconds")
	public void i_wait_for_seconds(int seconds) throws Throwable {
		myutility.i_wait_for_Seconds(seconds);
	}
}
