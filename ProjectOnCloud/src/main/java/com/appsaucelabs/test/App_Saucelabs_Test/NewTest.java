package com.appsaucelabs.test.App_Saucelabs_Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	public String baseurl = "http://google.com";

	@BeforeMethod
	public void launchbrowser()

	{
		System.out.println("LaunchBrowser called...");
		System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
	}

	@Test(priority = 0)
	public void GmailTap() {
		System.out.println("Test priority 0 called...");
		driver.findElement(By.linkText("Gmail")).click();

		System.out.println("hello");
		driver.findElement(By.id("Email")).sendKeys("innergytesting@gmail.com");
		driver.findElement(By.id("next")).click();

		boolean flag = true;
		while (flag) {
			try {
				driver.findElement(By.name("Passwd")).sendKeys("Testing@Test");
				System.out.println("Executed");
				flag = false;
			} catch (Exception e) {
			}
		}

		driver.findElement(By.id("signIn")).click();

		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();

	}

	@Test(priority = 1)
	public void GmailTap2() {
		System.out.println("Test priority 1 called...");

		System.out.println("Test priority 0 called...");
		driver.findElement(By.linkText("Gmail")).click();

		System.out.println("hello");
		driver.findElement(By.id("Email")).sendKeys("innergytesting@gmail.com");
		driver.findElement(By.id("next")).click();

		boolean flag = true;
		while (flag) {
			try {
				driver.findElement(By.name("Passwd")).sendKeys("Testing@Test");
				System.out.println("Executed");
				flag = false;
			} catch (Exception e) {
			}
		}

		driver.findElement(By.id("signIn")).click();

		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")));
		myDynamicElement.click();
		// driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();

	}

	// ____________

	@AfterMethod
	public void aftersignout() {
		System.out.println("aftersignOut called...");
		// New Accnt
		try {

			WebElement myDynamicElement = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account-chooser-link\"]")));
			myDynamicElement.click();

			driver.findElement(By.xpath("//*[@id=\"account-chooser-add-account\"]")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	// *[@id="account-chooser-add-account"]

}