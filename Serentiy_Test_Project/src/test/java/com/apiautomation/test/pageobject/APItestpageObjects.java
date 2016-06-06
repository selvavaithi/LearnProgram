package com.apiautomation.test.pageobject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import javax.xml.stream.XMLInputFactory;
import com.apiautomation.jacksonjson.GoogleAPIgeocode;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@DefaultUrl("https://maps.googleapis.com/maps/api/geocode/json?&address=softcrylic%20chennai")
public class APItestpageObjects extends MyPageObject {

	private ObjectMapper mapper;
	private URL url;
	private GoogleAPIgeocode googleapicode;

	public void jacksonJSON_Geocoding(String str) {

		// WebElement webElement=getDriver().findElement(By.tagName("pre"));
		// use Jackson map weather Json response
		// String weatherJsonString=webElement.getText();

		String url_string = geocodelocation_url + str;
		System.out.println(geocodelocation_url + str);
		XMLInputFactory f = XMLInputFactory.newFactory();

		mapper = new ObjectMapper();

		URL firsturl;
		try {
			firsturl = new URL(url_string);

			URI uri = new URI(firsturl.getProtocol(), firsturl.getUserInfo(), firsturl.getHost(), firsturl.getPort(),
					firsturl.getPath(), firsturl.getQuery(), firsturl.getRef());
			url = new URL(geocodelocation_url + URLEncoder.encode(str, "UTF-8"));

			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();

			scan.close();

			googleapicode = mapper.readValue(entireResponse, GoogleAPIgeocode.class);

			System.out.println("******************************************************************");
			System.out.println(googleapicode.getResults()[0].getFormatted_address());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getNearByPlacesFor(String nearby, String area) {

		latitude = Double.parseDouble(googleapicode.getResults()[0].getGeometry().getLocation().getLat());
		longitude = Double.parseDouble(googleapicode.getResults()[0].getGeometry().getLocation().getLng());

		System.out.println("latitude: " + latitude);
		System.out.println("longitude: " + longitude);

	}

	public void printCoordinatesfor(String area, String nearby) {
		// TODO Auto-generated method stub

	}

}
