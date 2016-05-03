package com.realbucks.test.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.realbucks.test.myutilities.My_PageObject;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;

public class Realbuck_Register_PageObject extends My_PageObject {

	@FindBy(id = "com.liquid.realbucks:id/hiw_page_1_content")
	private WebElement hiw_page_1_content;

	@FindBy(id = "com.liquid.realbucks:id/minireg_editText_first_name")
	private WebElementFacade FNtextbox;

	@FindBy(id = "com.liquid.realbucks:id/minireg_editText_last_initial")
	private WebElementFacade LNtextbox;

	@FindBy(id = "com.liquid.realbucks:id/minireg_editText_email")
	private WebElementFacade email_textbox;

	@FindBy(id = "com.liquid.realbucks:id/minireg_editText_password")
	private WebElementFacade password_textbox;

	@FindBy(className = "android.widget.ImageButton")
	private WebElement menu_btn;

	@FindBy(id = "com.liquid.realbucks:id/hiwnext")
	private WebElement nextbtn;

	@FindBy(id = "com.liquid.realbucks:id/minireg_btn_sign_up")
	private WebElement sign_up_btn;

	private WebDriver driver;

	public void clickTextBox() {
		System.out.println("going to find");
		withTimeoutOf(100, TimeUnit.SECONDS).waitFor(nextbtn);
		System.out.println("Next button is found");
		nextbtn.click();
		nextbtn.click();
		withTimeoutOf(100, TimeUnit.SECONDS).waitFor(FNtextbox);
	}

	public void VerifyEnteredText() {
		System.out.println("2 Verified ");
		sign_up_btn.click();
		System.out.println("3 Verified ");
	}

	public void EnterText() {
		FNtextbox.waitUntilVisible().sendKeys("Test FN");
		typein(LNtextbox, "This is our LN");
		typein(email_textbox, "test2016@pchmail.com");
		typein(password_textbox, "testing");
	}

	public void verifyMainMenu() {
		WebDriver facade = getDriver();
		driver = ((WebDriverFacade) facade).getProxiedDriver();

		WebElement action_bar_drawer_recycler = driver
				.findElement(By.id("com.liquid.realbucks:id/action_bar_drawer_recycler"));

		List<WebElement> tile_menu_hamburger_text = action_bar_drawer_recycler
				.findElements(By.className("android.widget.RelativeLayout"));

		// "com.liquid.realbucks:id/tile_menu_hamburger_text"));
		System.out.println("Menu items: " + tile_menu_hamburger_text.size());

		for (WebElement el : tile_menu_hamburger_text) {
			System.out.println(el.findElement(By.id("com.liquid.realbucks:id/tile_menu_hamburger_text")).getText());
		}
	}

	private void typein(WebElementFacade element, String string) {
		element.waitUntilVisible().sendKeys(string);
		getDriver().navigate().back();
		System.out.println("X: " + element.getLocation().getX() + " Y: " + element.getLocation().getY());
	}

	public void Click_menu_btn() {
		WaitWithTimeOut(menu_btn);
		menu_btn.click();
	}

	private void WaitWithTimeOut(WebElement element) {
		withTimeoutOf(30, TimeUnit.SECONDS).waitFor(element);
	}

}
