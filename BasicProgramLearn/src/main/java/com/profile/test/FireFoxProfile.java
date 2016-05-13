package com.profile.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/*
 * 
 * To Create profile in firefox refer this link
 * https://support.mozilla.org/en-US/kb/profile-manager-create-and-remove-firefox-profiles
 * 
 */
public class FireFoxProfile {

	public static void main(String[] args) {

		ProfilesIni profileini = new ProfilesIni();
		FirefoxProfile myprofile = profileini.getProfile("Test2");
		// Test2 is just a profile which has been created

		WebDriver driver = new FirefoxDriver(myprofile);
		driver.get("https://mail.google.com");
	}

}
