package com.test.serenitygrid.GridSerenityProcess.pageobject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jbehave.core.annotations.AfterScenario;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("http://www.pch.com")
public class GridSerenityProcesspageObject extends PageObject {

	private boolean acceptNextAlert = true;
	
	String geocodelocation_url = "https://maps.googleapis.com/maps/api/geocode/json?&address=";
	String nearbyplaceAPI_url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	private String YOUR_API_KEY = "AIzaSyCpkVhdnH1-uRn0Oi-ijvlFTdb94qFjHRk";
	private URL url;
	private HttpURLConnection conn;
	private JSONObject obj;
	private JSONArray arr;
	private double latitude, longitude;
	public static String[] namelist;
	
	@FindBy(linkText = "Register")
	public WebElementFacade registerlink;

	@FindBy(linkText = "Sign In")
	public WebElementFacade signinlink;

	@FindBy(css = "button.btn-signin.sign-in-btn")
	public WebElementFacade siginbtn;

	@FindBy(id = "FN")
	public WebElementFacade register_firstName;

	@FindBy(id = "LN")
	public WebElementFacade register_lastName;

	@FindBy(id = "ZI")
	public WebElementFacade register_zipCode;

	@FindBy(id = "TI")
	public WebElementFacade register_title;

	@FindBy(id = "sub-btn")
	public WebElementFacade register_submitBtn;

	@FindBy(id = "chkRememberMe")
	public WebElementFacade register_checkRememberMe;

	@FindBy(css = "div.sso-outer-shell > div.header")
	public WebElementFacade register_validation_errorMsg_header;

	@WhenPageOpens
	public void waitUntilElementsisVisible() {
		try {
			signinlink.waitUntilClickable();
			System.out.println("Element found ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickRegisterBtn() {
		registerlink.click();
	}

	public void verifyRegisterpage() {
		VerifyText(getDriver().getTitle().toString(), "PCH Contest | Win $7,000.00 a Week For Life!!");
	}

	public void click_register_submit_btn() {
		register_submitBtn.click();
	}

	public void verify_register_validation_error_msg() {
		register_validation_errorMsg_header.waitUntilPresent();
		System.out.println("Starting the elements");
		List<WebElement> elements = getDriver().findElements(By.xpath("//body[@id='bodyTag']/div[5]/div[2]/div"));

		System.out.println("Size: " + elements.size());

		for (WebElement s : elements) {
			System.out.println("text: " + s.getText());
		}

		String str = register_validation_errorMsg_header.getText();
		VerifyText(str, "PLEASE FILL IN THE FOLLOWING FIELDS:");

	}

	private void VerifyText(String string, String string2) {
		try {
			System.out.println("Compare :" + string + " with " + string2);
			Assert.assertEquals(string, string2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = getDriver().switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	public void enterFirstName(String firstname) {
		register_firstName.waitUntilVisible().type(firstname);

	}

	public void enterLastName(String lastname) {
		register_lastName.waitUntilVisible().type(lastname);
	}
	
	public void getGeocodingfor(String str) {
		System.out.println(geocodelocation_url + str);
		obj = new JSONObject(returnJSONformURL(geocodelocation_url + str));
		String responseCode = obj.getString("status");
		System.out.println("status : " + responseCode);
		arr = obj.getJSONArray("results");
		for (int i = 0; i < arr.length(); i++) {
			JSONObject placeid = arr.getJSONObject(i).getJSONObject("geometry").getJSONObject("location");
			latitude = placeid.getDouble("lat");
			longitude = placeid.getDouble("lng");
			System.out.println("latitude: " + latitude);
			System.out.println("longitude: " + longitude);
		}
	}
	
	public void getNearByPlacesFor(String str) {
		String nearbyplaceAPIformed = "location=" + latitude + "," + longitude + "&radius=500&type=" + str + "&key="
				+ YOUR_API_KEY;
		obj = new JSONObject(returnJSONformURL(nearbyplaceAPI_url + nearbyplaceAPIformed));
		String responseCode = obj.getString("status");
		System.out.println("status 123: " + responseCode);
		arr = obj.getJSONArray("results");
		String placeid;
		namelist = new String[arr.length()];
		for (int i = 0; i < arr.length(); i++) {
			placeid = arr.getJSONObject(i).getString("name");
			namelist[i] = placeid;
			System.out.println("name: " + placeid);
		}
	}

	public void searchNearByPlacesWithName(String types, String types_name) {
		String nearbyplaceAPIformed = "location=" + latitude + "," + longitude + "&radius=500&type=" + types + "&name="
				+ types_name + "&key=" + YOUR_API_KEY;

		obj = new JSONObject(returnJSONformURL(nearbyplaceAPI_url + nearbyplaceAPIformed));
		String responseCode = obj.getString("status");
		System.out.println("status 123: " + responseCode);

		arr = obj.getJSONArray("results");
		for (int i = 0; i < arr.length(); i++) {
			String placeid = arr.getJSONObject(i).getString("name");
			System.out.println("name: " + placeid);
		}
	}

	private String returnJSONformURL(String url_string) {
		String entireResponse = new String();
		try {
			URL firsturl = new URL(url_string);
			URI uri = new URI(firsturl.getProtocol(), firsturl.getUserInfo(), firsturl.getHost(), firsturl.getPort(),
					firsturl.getPath(), firsturl.getQuery(), firsturl.getRef());
			url = uri.toURL();
			// url = new URL(url_string);
			System.out.println("API URL: " + url);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
			}
			Scanner scan = new Scanner(url.openStream());

			while (scan.hasNext())
				entireResponse += scan.nextLine();
			System.out.println("Response : " + entireResponse);
			scan.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return entireResponse;
	}


	@AfterScenario
	public void AfterScenarioSteps() {
		System.out.println("After scenario***************");
		((JavascriptExecutor) getDriver()).executeScript("window.onbeforeunload = function(e){};");
	}

}
