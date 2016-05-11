package com.sampleapp.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class SampleAppTest_PageObject extends PageObject {

	@FindBy(id = "io.selendroid.testapp:id/inputUsername")
	WebElement username;

	@FindBy(id = "io.selendroid.testapp:id/inputEmail")
	WebElement inputEmail;

	@FindBy(id = "io.selendroid.testapp:id/inputPassword")
	WebElement inputPassword;

	@FindBy(id = "io.selendroid.testapp:id/inputName")
	WebElement inputName;

	@FindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	WebElement input_preferedProgrammingLanguage;

	@FindBy(id = "io.selendroid.testapp:id/input_adds")
	WebElement input_adds_check;

	@FindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	WebElement btnRegisterUser;

	@FindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	WebElement startUserRegistration;

	@FindBy(id = "com.android2.calculator3:id/cling_dismiss")
	WebElement cling_dismiss;

	public void fillRegisterPage() {
		WebElement inputEmail1 = getDriver().findElement(By.id("io.selendroid.testapp:id/inputEmail"));
		// fill username, password, email and name
		wait_for_it(inputEmail1).sendKeys("testing@test.com");
		// Select the program language
		// select the tick
		// click on register button
	}

	public void click_startUserRegistration() {
		WebElement startUserRegistration1 = getDriver().findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		wait_and_click(startUserRegistration1);
	}

	public void verify_App_HomePage() {
		// verify the text Hello Default Locale, Selendroid-test-app!
		WebElement startUserRegistration1 = getDriver().findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		wait_for_it(startUserRegistration1);
		System.out.println("Button status: " + startUserRegistration1.isDisplayed());
	}

	public void verify_App_registrationPage() {
		// TODO Auto-generated method stub

	}

	private void wait_and_click(WebElement element) {
		wait_for_it(element).click();
	}

	private WebElement wait_for_it(WebElement ele) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		return element;
	}

}
