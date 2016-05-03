package com.realbucks.test.stepsmodules;

import com.realbucks.test.pageobject.Realbuck_Register_PageObject;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Step;

public class RealBucks_RegisterPage_Modules {

	@ManagedPages
	Realbuck_Register_PageObject realbuckpageobject;

	@Step
	public void clickOntextbox() {
		realbuckpageobject.clickTextBox();
	}

	@Step
	public void verifyenteredtext() {
		realbuckpageobject.VerifyEnteredText();
	}

	@Step
	public void entertext() {
		realbuckpageobject.EnterText();
	}

	@Step
	public void verifyMenuSets() {
		realbuckpageobject.verifyMainMenu();
	}

	@Step
	public void ClickMenuBtn() {
		realbuckpageobject.Click_menu_btn();
	}
}
