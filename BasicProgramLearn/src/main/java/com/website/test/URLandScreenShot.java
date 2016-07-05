package com.website.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class URLandScreenShot {

	private static WebDriver driver;
	private static LinkedList<String[]> list = new LinkedList<String[]>();
	private static WebDriverWait wait;
	private static String WEB_BROWSER = "ie";
	private static String bodyTagcss = "body#bodyTag";
	private static String dateString, timeString;

	@BeforeClass
	public static void setUp() {
		try {

			// Creating a folder
			Date dNow = new Date();
			DateFormat format2 = new SimpleDateFormat("EEEE MMMMM dd, yyyy");
			dateString = format2.format(dNow);
			System.out.println(dateString);

			SimpleDateFormat ft = new SimpleDateFormat("hh_mm_ss a zzz");
			timeString = ft.format(dNow);
			System.out.println("Current Date: " + timeString);
			File file = new File("D://VinothImage//" + dateString + "//" + timeString + "//");
			file.mkdirs();
			// Creating a dialog box for choosing the browser
			String[] choices = { "FIREFOX", "CHROME", "IE" };
			WEB_BROWSER = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);
			System.out.println(WEB_BROWSER);

			// Reading the file and storing it in a LinkedList
			BufferedReader br = new BufferedReader(new FileReader("PrismPath_06_29_2016.txt"));
			String textContent;
			while ((textContent = br.readLine()) != null) {
				list.add(textContent.split("\\t"));
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (WEB_BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (WEB_BROWSER.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "D:\\WorkSpace\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if (WEB_BROWSER.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\WorkSpace\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		wait = new WebDriverWait(driver, 30);

	}

	@Test
	public void Test1() throws InterruptedException {

		String url;
		for (int i = 1; i < list.size(); i++) {
			url = list.get(i)[1].replace("\"", ""); // Getting the URL

			if (i == 1) {
				driver.get(list.get(1)[1].replace("\"", "")); // removing the
																// double quotes
				Thread.sleep(5000);
				DotheSignIn();
				Thread.sleep(5000);
				((JavascriptExecutor) driver).executeScript("window.onbeforeunload = function(e){};");
			}
			driver.get(url);
			System.out.println(i + ") " + url);
			// checkButtonAndClick();

			JavaOptionAlert(); // just waiting for the manuel operation to
								// finish
			/*
			 * return fSubmitMe(); WebElement bodyTag =
			 * driver.findElement(By.cssSelector(bodyTagcss));
			 * 
			 * String contents =
			 * (String)((JavascriptExecutor)driver).executeScript(
			 * "return arguments[0].innerHTML;", bodyTag);
			 * System.out.println(contents);
			 */

			// if(driver.getPageSource().contains(s))

			TakeScreenShot(url, i);

			Thread.sleep(1000);
			// removing the confirmation alert for page movement
			((JavascriptExecutor) driver).executeScript("window.onbeforeunload = function(e){};");
			Thread.sleep(1000);
		}
	}

	private void JavaOptionAlert() {
		int dialogButton = JOptionPane.YES_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Finishe the manuel handle Please", "Manuel handle",
				dialogButton);

		if (dialogResult == 0) {
			System.out.println("Yes option - Manuel handle is finished");
		}
	}

	private void TakeScreenShot(String url, int i) {

		WebElement ulList = getElement(By.cssSelector("ul#mpPageNavTop.mpPageNavTop"));
		List<WebElement> liList = ulList.findElements(By.tagName("li"));
		// getting the 'li' ement
		System.out.println(liList.size());

		String[] imgName = url.split("/");
		// getting the Page ID for image naming
		String filename;

		try {
			if (liList.size() > 0) {

				for (int j = 0; j < liList.size() - 2; j++) {
					getElement(By.id("mpPageNavTop_" + j));
					Thread.sleep(3000);
					File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					filename = "D://VinothImage//" + dateString + "//" + timeString + "//" + imgName[imgName.length - 2]
							+ "_" + imgName[imgName.length - 1] + "_tab_" + (j + 1) + ".png";
					System.out.println("Saved the File as " + filename);
					FileUtils.copyFile(scrFile, new File(filename));

					getElement(By.cssSelector("#mpNavNext > a")).click();
					// clicking the CONTINUE button in the tab
				}
			}

			/*
			 * final Screenshot screenshot = new AShot().shootingStrategy(new
			 * ViewportPastingStrategy(500)) .takeScreenshot(driver); final
			 * BufferedImage image = screenshot.getImage(); ImageIO.write(image,
			 * "PNG", new File("D://VinothImage//" + imgName[imgName.length - 1]
			 * + ".png"));
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void checkButtonAndClick() throws InterruptedException {
		getElement(By.cssSelector(bodyTagcss));
		BtnFinderNames bfn = new BtnFinderNames();
		String str = driver.getPageSource();

		if (str.contains(bfn.yesButton)) {
			System.out.println(bfn.yesButton);
			getElement(By.cssSelector("#yesButton > a > img")).click();
		}
		if (str.contains(bfn.ea_claim_btn_bounceLess_aniTiming)) {
			System.out.println(bfn.ea_claim_btn_bounceLess_aniTiming);
			getElement(By.cssSelector("div.ea_claim_btn.bounceLess.aniTiming")).click();
		}
		if (str.contains(bfn.ta_continue_btn)) {
			System.out.println(bfn.ta_continue_btn);
			getElement(By.cssSelector("div.ta_continue_btn")).click();
		}
		if (str.contains(bfn.platinumClaimBtn)) {
			System.out.println(bfn.platinumClaimBtn);
			getElement(By.id("platinumClaimBtn")).click();
		}

		Thread.sleep(6000);

		// ((JavascriptExecutor) driver).executeScript("return fSubmitMe();");
		/*
		 * WebElement bodyTag = driver.findElement(By.cssSelector(bodyTagcss));
		 * 
		 * System.out.println(bodyTag.isDisplayed());
		 * bodyTag.findElement(By.tagName("form")).submit();
		 */

		System.out.println("java finished");
	}

	private void DotheSignIn() {
		getElement(By.linkText("Sign In")).click();
		getElement(By.id("txtEmailAddress")).clear();
		getElement(By.id("txtEmailAddress")).sendKeys("testking01@pchmail.com");
		getElement(By.id("txtPassword")).clear();
		getElement(By.id("txtPassword")).sendKeys("tester");
		getElement(By.id("btnSignIn")).click();
	}

	private WebElement getElement(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
}

class BtnFinderNames {
	String ta_continue_btn = "ta_continue_btn";
	String yesButton = "yesButton";
	String platinumClaimBtn = "platinumClaimBtn";
	String ea_claim_btn_bounceLess_aniTiming = "ea_claim_btn";
}
