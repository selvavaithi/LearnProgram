package com.cucumebrApp.Test.Steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberAppTestSteps {

	@Given("^I go to \"(.*)\"$")
	public void i_go_to_https_www_google_com(String site) throws Throwable {
		System.out.println(site);
	}

	@Given("^observer the search bar is present$")
	public void observer_the_search_bar_is_present() throws Throwable {
		System.out.println("^observer the search bar is present$");
	}

	@When("^I type \"(.*)\" in the search bar$")
	public void i_type_testing_methodologies_in_the_search_bar(String search) throws Throwable {
		System.out.println(search);
	}

	@When("^I hit enter$")
	public void i_hit_enter() throws Throwable {
		System.out.println("^I hit enter$");
	}

	@Then("^I validate the the page has \"(.*)\"$")
	public void i_validate_the_the_page_has_testing_methodologies_Google_Search(String title) throws Throwable {
		System.out.println(title);
	}

	@Then("^I check for the number of counts of the link in that page$")
	public void i_check_for_the_number_of_counts_of_the_link_in_that_page() throws Throwable {
		System.out.println("^I check for the number of counts of the link in that page$");
	}

	@Given("^I want to write a step with \"([^\"]*)\"$")
	public void i_want_to_write_a_step_with(String arg1) throws Throwable {
		System.out.println(arg1);
	}

	@When("^I check for the \"([^\"]*)\" in step$")
	public void i_check_for_the_in_step(String arg1) throws Throwable {
		System.out.println(arg1);
	}

	@Then("^I verify the \"(.*)\" in step$")
	public void i_verify_the_success_in_step(String status) throws Throwable {
		System.out.println(status);
	}

}
