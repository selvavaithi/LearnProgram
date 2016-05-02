package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Library {
	private static WebDriver driver;
	String baseUrl = "https://www.google.co.in/?gfe_rd=cr&ei=TAQjV-C8A-KK8QfGlaWYDw&gws_rd=ssl";
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass
	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Gmail")).click();
		driver.findElement(By.id("account-chooser-add-account")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("sdfsdsdsdf");
		driver.findElement(By.id("next")).click();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}