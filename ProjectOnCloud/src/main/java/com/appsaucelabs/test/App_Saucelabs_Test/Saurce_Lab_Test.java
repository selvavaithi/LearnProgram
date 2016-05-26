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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * 
 * #mvn verify -Dsaucelabs.target.platform=XP -Dwebdriver.driver=chrome -Dsaucelabs.driver.version=44.0 -Dsaucelabs.url=http://selvatesting:a53f3b04-441e-4274-83c9-68b27d9cfc4d@ondemand.saucelabs.com:80/wd/hub -Dsaucelabs.access.key=<YOUR ACCESS KEY> -Dsaucelabs.user.id=<USERNAME> -Dwebdriver.base.url=<TEST SITE URL> -Dmaven.test.failure.ignore=true
 * 
 * **/

public class Saurce_Lab_Test {

	private static WebDriver driver;
	private static WebDriverWait wait;
	// "selvatesting";
	public static final String USERNAME = "blogman";
	// "a53f3b04-441e-4274-83c9-68b27d9cfc4d";
	public static final String ACCESS_KEY = "7c3c1b17-0cc6-412a-a816-1f59552800c0";
	// johntest1; 17ca1a7f-001c-4c32-8eda-a7c1ec4cd0a0
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
		String platform = "ios";
		DesiredCapabilities caps;
		if (platform.equalsIgnoreCase("android")) {
			caps = DesiredCapabilities.android();
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

		if (platform.equalsIgnoreCase("ios")) {
			caps = DesiredCapabilities.iphone();
			caps.setCapability("appiumVersion", "1.5.2");
			caps.setCapability("deviceName", "iPhone 6");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("platformVersion", "9.2");
			caps.setCapability("platformName", "iOS");
			caps.setCapability("browserName", "");
			caps.setCapability("app", "sauce-storage:appzip.zip");

			try {
				driver = new IOSDriver<WebElement>(new URL(URL), caps);
				wait = new WebDriverWait(driver, 100);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
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
