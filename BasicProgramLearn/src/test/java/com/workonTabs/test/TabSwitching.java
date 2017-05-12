package com.workonTabs.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabSwitching {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "D:/WorkSpace/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.google.com/xhtml");
		Thread.sleep(5000);
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Software testing");
		searchBox.submit();

		System.out.println("Current Url: " + driver.getCurrentUrl());

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.r a")));

		List<WebElement> results = driver.findElements(By.xpath("//h3[@class='r']/a"));

		for (WebElement ele : results) {
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
			ele.sendKeys(selectLinkOpeninNewTab);
		}
		Thread.sleep(5000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs2.size());

		for (int i = tabs2.size() - 1; i >= 0; i--) {
			Thread.sleep(2000);
			driver.switchTo().window(tabs2.get(i));
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			System.out.println(driver.getTitle() + "i: " + i);
			driver.close();
		}
	}
}
