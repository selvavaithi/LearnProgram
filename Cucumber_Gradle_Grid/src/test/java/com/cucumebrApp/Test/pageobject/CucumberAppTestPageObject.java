package com.cucumebrApp.Test.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumebrApp.utility.MyUtility;
import net.serenitybdd.core.pages.PageObject;

public class CucumberAppTestPageObject extends PageObject {

	@FindBy(id = "lst-ib")
	private WebElement searchbox;

	MyUtility myutility = new MyUtility();

	/*
	 * private WebDriverWait wait = new WebDriverWait(getDriver(), 15); private
	 * 
	 */
	public void i_go_to(String site) {
		System.out.println(site);
		getDriver().get(site);
	}

	public void observer_the_search_bar_is_present() {
		System.out.println("^observer the search bar is present$");
		waitForelement(searchbox);
	}

	private void waitForelement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void i_type_in_the_search_bar(String search) {
		System.out.println(search);
		searchbox.sendKeys(search);
	}

	public void i_hit_enter() {
		System.out.println("^I hit enter$");
		myutility.Hit_Enter();
	}

	public void i_validate_that_the_page_title(String title) {
		System.out.println(title);
		Assert.assertEquals(title, getDriver().getTitle());
	}

	public void i_check_result_count() {
		System.out.println("^I check for the number of counts of the link in that page$");
		List<WebElement> result_list = getDriver().findElements(By.cssSelector("h3.r > a"));
		System.out.println("The result count is " + result_list.size());
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
