package com.test.serenitygrid.GridSerenityProcess.pageobject;

import java.util.List;

import org.jbehave.core.annotations.AfterScenario;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("http://www.pch.com")
public class GridSerenityProcesspageObject extends PageObject {

	private boolean acceptNextAlert = true;

	@FindBy(linkText = "Register")
	public WebElementFacade registerlink;

	@FindBy(linkText = "Sign In")
	public WebElementFacade signinlink;

	@FindBy(css = "button.btn-signin.sign-in-btn")
	public WebElementFacade siginbtn;

	@FindBy(id = "FN")
	public WebElementFacade register_firstName;

	@FindBy(id = "LN")
	public WebElementFacade register_lastName;

	@FindBy(id = "ZI")
	public WebElementFacade register_zipCode;

	@FindBy(id = "TI")
	public WebElementFacade register_title;

	@FindBy(id = "sub-btn")
	public WebElementFacade register_submitBtn;

	@FindBy(id = "chkRememberMe")
	public WebElementFacade register_checkRememberMe;

	@FindBy(css = "div.sso-outer-shell > div.header")
	public WebElementFacade register_validation_errorMsg_header;

	@WhenPageOpens
	public void waitUntilElementsisVisible() {
		try {
			signinlink.waitUntilClickable();
			System.out.println("Element found ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRegisterBtn() {
		registerlink.click();
	}

	public void verifyRegisterpage() {
		VerifyText(getDriver().getTitle().toString(), "PCH Contest | Win $7,000.00 a Week For Life!!");
	}

	public void click_register_submit_btn() {
		register_submitBtn.click();
	}

	public void verify_register_validation_error_msg() {
		register_validation_errorMsg_header.waitUntilPresent();
		System.out.println("Starting the elements");
		List<WebElement> elements = getDriver().findElements(By.xpath("//body[@id='bodyTag']/div[5]/div[2]/div"));

		System.out.println("Size: " + elements.size());

		for (WebElement s : elements) {
			System.out.println("text: " + s.getText());
		}

		String str = register_validation_errorMsg_header.getText();
		VerifyText(str, "PLEASE FILL IN THE FOLLOWING FIELDS:");

	}

	private void VerifyText(String string, String string2) {
		try {
			System.out.println("Compare :" + string + " with " + string2);
			Assert.assertEquals(string, string2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = getDriver().switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public void enterFirstName(String firstname) {
		register_firstName.waitUntilVisible().type(firstname);

	}

	public void enterLastName(String lastname) {
		register_lastName.waitUntilVisible().type(lastname);
	}

	@AfterScenario
	public void AfterScenarioSteps() {
		System.out.println("After scenario***************");
		((JavascriptExecutor) getDriver()).executeScript("window.onbeforeunload = function(e){};");
	}

}
