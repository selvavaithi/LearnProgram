package com.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class GETresponsePrint {
	static String my_url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=13.0329202,80.2422843&key=%20AIzaSyAp1-BabhlqpTo0BT8ku8VB25QYmEw98ko";

	public static void main(String[] args) {
		try {
			// GetResponseTry();
			// GetResponseTry1();
			GetResponseTry2();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void GetResponseTry2() throws ClientProtocolException, IOException {
		// Create client http
		CloseableHttpClient client = HttpClientBuilder.create().build();
		
		// Create Get method
		HttpGet get = new HttpGet(my_url);

		// Create Response
		HttpResponse response = client.execute(get);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		System.out.println(new UrlEncodedFormEntity(urlParameters));

		String output = "", str;
		str = br.readLine();
		while (str != null) {
			output += str;
			str = br.readLine();
		}
		System.out.println(output);

		client.close();
	}

	private static void GetResponseTry1() throws ClientProtocolException, IOException {

		// create client
		CloseableHttpClient client = HttpClientBuilder.create().build();

		// Creat Get code
		HttpGet get = new HttpGet(my_url);
		get.addHeader("AuthTicket:",
				"VWx5akJpQk0zTTVXMUxTLzBzNFRIQnJnQ2ZYbGgyOHZHSzNzbkZwTmxjMzZvNnQ1cDhnUlRLUkFiWGlQcHVSSlRrNlIvdDdyWWNxZks3MWM1amxpYTVOZ1N1SzZmblk0QkMyVWNqR3hBWDJDM2Y2dzJjWGFqMk9DVlFOVFkwUEVscEpEbXBMTWFNaWJ6YlJuUXZ3UHd0MDJ1L2pUTjF5ZWQvdzJWRmMvMktZPTtXZWQsIDI5IEp1biAyMDE2IDExOjE3OjMyIEdNVDtUcnVlOzc5MWUzMjYyLTBkNTAtNDg5Zi1iMjhiLTEzNzc5NjQ1ZTIyYzs3OTFlMzI2Mi0wZDUwLTQ4OWYtYjI4Yi0xMzc3OTY0NWUyMmM=");

		// Get the response
		HttpResponse response = client.execute(get);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Error: " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String output = new String();
		String str = br.readLine();
		while (str != null) {
			output += str;
			str = br.readLine();
		}
		System.out.println("value: " + output);
		client.close();
	}

	private static void GetResponseTry() throws IOException {

		HttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet(my_url);
		Header headervalue = null;
		get.addHeader(headervalue);

		HttpResponse response = httpclient.execute(get);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed Error code: " + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String output = null;
		System.out.println("Output from Server .... \n");

		while (br.readLine() != null) {
			output += br.readLine();
		}
		System.out.println(output);

		httpclient.getConnectionManager().shutdown();
	}
}
