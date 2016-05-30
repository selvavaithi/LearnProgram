package com.appsaucelabs.test.App_Saucelabs_Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.ios.IOSDriver;

public class Saucelabs_Mobile_WebTest {

	private static DesiredCapabilities caps;
	private static WebDriver driver;
	private static WebDriverWait wait;

	public static final String USERNAME = "freetrialuser";
	public static final String ACCESS_KEY = "9c241d70-8f67-45e1-9521-29c1ec9f8b3b";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@BeforeClass
	public static void setUp() {

		caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.5.2");
		caps.setCapability("deviceName", "iPad 2");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion", "9.2");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");

		try {
			driver = new IOSDriver<WebElement>(new URL(URL), caps);
			wait = new WebDriverWait(driver, 100);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void runTest() throws Exception {
		driver.get("http://saucelabs.com/test/guinea-pig");
		Thread.sleep(1000);
		WebElement idElement = driver.findElement(By.id("i_am_an_id"));
		assertNotNull(idElement);
		assertEquals("I am a div", idElement.getText());
		driver.findElement(By.id("i_am_a_textbox")).sendKeys("This is just a testing text");
		WebElement commentElement = driver.findElement(By.id("comments"));
		assertNotNull(commentElement);
		commentElement.sendKeys("This is an awesome comment");
		WebElement submitElement = driver.findElement(By.id("submit"));
		assertNotNull(submitElement);
		submitElement.click();
		Thread.sleep(7000);
		WebElement yourCommentsElement = driver.findElement(By.id("your_comments"));
		assertNotNull(yourCommentsElement);
		assertTrue(driver.findElement(By.id("your_comments")).getText().contains("This is an awesome comment"));

		System.out.println(driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
