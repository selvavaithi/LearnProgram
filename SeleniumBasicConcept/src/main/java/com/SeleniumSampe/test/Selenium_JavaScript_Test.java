package com.SeleniumSampe.test;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Selenium_JavaScript_Test {

	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {

		System.setProperty("webdriver.ie.driver", "D://WorkSpace//Driver//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get("https://github.com/");

		WebElement ele = driver.findElement(By.cssSelector("a.js-selected-navigation-item.nav-item.nav-item-personal"));

		// read script file
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));

			Thread.sleep(3000);

			String workingDir = System.getProperty("user.dir") + "\\needful\\xmlhttp.js";
			System.out.println(workingDir);

			String fileContents = Files.toString(new File(workingDir), Charsets.UTF_8);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(fileContents);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void Testing() {
		System.out.println("testing");
	}

	@AfterClass
	public static void tearDown() {
		/*try {
			Thread.sleep(10000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
