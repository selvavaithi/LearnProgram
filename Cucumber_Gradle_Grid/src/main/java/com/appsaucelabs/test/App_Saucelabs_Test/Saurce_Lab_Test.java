package com.appsaucelabs.test.App_Saucelabs_Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Unit test for simple App.
 */
public class Saurce_Lab_Test {

	private static WebDriver driver;
	private static WebDriverWait wait;
	// "selvatesting";
	public static final String USERNAME = "johntest1";
	// "a53f3b04-441e-4274-83c9-68b27d9cfc4d";
	public static final String ACCESS_KEY = "17ca1a7f-001c-4c32-8eda-a7c1ec4cd0a0";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
	WebElement username;

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputEmail")
	WebElement inputEmail;

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
	WebElement inputPassword;

	@AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
	WebElement inputName;

	@AndroidFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
	WebElement input_preferedProgrammingLanguage;

	@AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
	WebElement input_adds_check;

	@AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
	WebElement btnRegisterUser;

	@AndroidFindBy(id = "io.selendroid.testapp:id/startUserRegistration")
	WebElement startUserRegistration;

	// https://github.com/appium/sample-code/blob/master/sample-code/apps/ContactManager/ContactManager.apk?raw=true
	// http://search.maven.org/remotecontent?filepath=io/selendroid/selendroid-test-app/0.17.0/selendroid-test-app-0.17.0.apk

	@BeforeClass
	public static void setUp() {
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.5.2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		caps.setCapability("deviceType", "phone");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.APP,
				"https://github.com/selvavaithi/LearnBasic/blob/master/selendroid-test-app-0.17.0.apk?raw=true");
		caps.setCapability("appPackage", "io.selendroid.testapp");// "io.selendroid.testapp"
		caps.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");// "io.selendroid.testapp.HomeScreenActivity"

		try {
			driver = new AndroidDriver<WebElement>(new URL(URL), caps);
			wait = new WebDriverWait(driver, 100);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		WebElement startUserRegistration1 = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		wait.until(ExpectedConditions.elementToBeClickable(startUserRegistration1));
		startUserRegistration1.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement inputEmail1 = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
		wait_for_it(inputEmail1).sendKeys("testing@test.com");

		WebElement inputName1 = driver.findElement(By.id("io.selendroid.testapp:id/inputName"));
		wait_for_it(inputName1).sendKeys("First Name Test");

		WebElement inputPassword1 = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
		wait_for_it(inputPassword1).sendKeys("password");
	}

	private WebElement wait_for_it(WebElement ele) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		return element;
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
