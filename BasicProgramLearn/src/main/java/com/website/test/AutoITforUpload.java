package com.website.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoITforUpload {
	private static WebDriver driver;

	private static WebDriverWait waitForElement;

	@FindBy(css = "span.btn.btn-success.fileinput-button")
	private WebElement Add_files_btn;

	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		waitForElement = new WebDriverWait(driver, 30);
	}

	@Test
	public void AutoitUpload() {
		// String filepath =
		// "D:/Mine/GitHub/BasicProgramLearn/AutoItScript/unnamed.png";
		WebElement btn = driver.findElement(By.cssSelector("span.btn.btn-success.fileinput-button"));
		waitForElement(btn);
		btn.click();
		String file_dir = System.getProperty("user.dir");
		String cmd = file_dir + "\\AutoItScript\\unnamed.png";

		System.out.println("File directory is " + file_dir);

		try {
			Thread.sleep(3000);
			System.out.println(file_dir + "/AutoItScript/FileUploadCode.exe");
			Runtime.getRuntime().exec(file_dir + "\\AutoItScript\\FileUploadCode.exe" + " " + cmd);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public static void TearDown() {
		try {
			Thread.sleep(5600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

	private void waitForElement(WebElement vElement) {
		waitForElement.until(ExpectedConditions.visibilityOf(vElement));
	}
}