package com.apiautomation.test.pageobject;

import net.serenitybdd.core.pages.PageObject;

public class MyPageObject extends PageObject {
	
	String geocodelocation_url = "https://maps.googleapis.com/maps/api/geocode/json?&address=";
	String geocodelocation_url_xml = "https://maps.googleapis.com/maps/api/geocode/xml?&address=";
	String nearbyplaceAPI_url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	protected String YOUR_API_KEY = "AIzaSyCpkVhdnH1-uRn0Oi-ijvlFTdb94qFjHRk";
	public double latitude;
	public double longitude;
	public static String[] namelist;

}
