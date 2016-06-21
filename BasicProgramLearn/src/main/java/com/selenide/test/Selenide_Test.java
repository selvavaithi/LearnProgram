package com.selenide.test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors.ByText;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class Selenide_Test {

	private static String baseUrl;
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/Driver/chromedriver.exe");
		//Configuration.browser = "chrome";
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);
		baseUrl = "http://demoqa.com/";
		open(baseUrl);
		/*
		 * DesiredCapabilities desicap = new DesiredCapabilities();
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:/WorkSpace/Driver/chromedriver.exe"); desicap =
		 * DesiredCapabilities.chrome();
		 * 
		 * driver = "chrome".equals(System.getProperty("selenide.browser")) ?
		 * new ChromeDriver(desicap) : new FirefoxDriver();
		 */
		driver.manage().window().maximize();

	}

	@Test
	public void userCanLoginByUsername() {
		// open(baseUrl);
		SelenideElement stest = $(By.linkText("About us")).waitUntil(visible, 10000);
		stest.click();
		 System.out.println($(By.linkText("About us")));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
