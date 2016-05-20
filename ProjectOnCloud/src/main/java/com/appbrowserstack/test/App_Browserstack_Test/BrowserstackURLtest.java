package com.appbrowserstack.test.App_Browserstack_Test;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserstackURLtest {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability("browserName", "android");
		capability.setCapability("platform", "ANDROID");
		capability.setCapability("device", "Samsung Galaxy S5");
		capability.setCapability("browserstack.debug", true);
		driver = new RemoteWebDriver(new URL("https://selva104:HsscP2xiMMajWar3MKj4@hub.browserstack.com/wd/hub"),
				capability);
	}

	@Test
	public void testSimple() throws Exception {
		driver.get("http://www.google.com");
		System.out.println("Page title is: " + driver.getTitle());
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
