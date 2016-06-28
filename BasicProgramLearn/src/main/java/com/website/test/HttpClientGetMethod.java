package com.website.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientGetMethod {
	private final static String USER_AGENT = "Mozilla/5.0";
	private static String uriLogin = "https://mail.google.com";
	private static String uriContacts = "https://mail.google.com/mail/shva=1#contacts";

	// the account was registered just for test:
	private static String myAcc = "innergytesting";
	private static String myPwd = "Testing@Test";

	public static void main(String[] args) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(uriLogin);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("Email", myAcc));
		params.add(new BasicNameValuePair("Passwd", myPwd));

		try {
			post.setEntity(new UrlEncodedFormEntity(params));

			HttpResponse response = client.execute(post);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
