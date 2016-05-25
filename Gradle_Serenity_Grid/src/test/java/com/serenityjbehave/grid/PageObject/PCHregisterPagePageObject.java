package com.serenityjbehave.grid.PageObject;

import java.io.IOException;
import java.util.List;
import org.jbehave.core.annotations.AfterScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;


public class PCHregisterPagePageObject extends MyPageObjects {

	public void ClickOnTheRegistrationButton() {
		register_btn.waitUntilClickable().click();
	}

	public void IShouldPresentInRegistrationPage() {
		reg_submit_btn.waitUntilClickable();
	}

	@AfterScenario
	public void afterscenarioWork() {
		Sleeper.sleepTightInSeconds(3);
		((JavascriptExecutor) getDriver()).executeScript("window.onbeforeunload = function(e){};");
	}

	public void clickUploadButton() {
		Add_files_btn.waitUntilClickable().click();
	}

	public void applyAutoIt() {
		
		String file_dir = System.getProperty("user.dir");
		String cmd = file_dir + "\\AutoItScript\\unnamed.png";

		try {
			Runtime.getRuntime().exec(file_dir + "\\AutoItScript\\FileUploadCode.exe" + " " + cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Verifythefileisuploaded() {
		List<WebElement> elements = getDriver().findElements(By.cssSelector("tr.template-upload.fade.in"));
		System.out.println("List of elements are "+elements.size());
	}
	
}
