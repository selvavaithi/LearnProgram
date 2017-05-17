package com.prasing.jacksonJSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson_JSONexample {

	public static void main(String[] args) {

		JSON_jackson json_jackson = new JSON_jackson();

		Application applicaiton = new Application();

		applicaiton.setAppCode("PCHCOM");
		applicaiton.setPlatformCode("PCHCOMHOME");

		Source source = new Source();
		source.setTrackingToken("");
		source.setSourceCode("PCHCOM");
		source.setForeignSource("");
		source.setOriginatingUrl("http://centralservices.cqa.pch.com/rfapi_v9/Svc/TestPage.aspx");
		source.setMediaChannel("ACQ");
		source.setEmailSubCode("");

		IpAddress ipaddress = new IpAddress();
		ipaddress.setServerIp("10.1.1.228");
		ipaddress.setClientIp("24.193.86.57");

		Client client = new Client();
		client.setUserAgentId("975138");
		client.setDeviceType("DESKTOP");

		json_jackson.setApplication(applicaiton);
		json_jackson.setSource(source);
		json_jackson.setIpAddress(ipaddress);
		json_jackson.setClient(client);
		json_jackson.setGlobalMemberToken("bca8e25b-89c0-4072-97aa-5a7901ddb4d1");
		json_jackson.setPassword("pch123");

		ObjectMapper mapper = new ObjectMapper();

		try {

			File jsonFile = new File(System.getProperty("user.dir") + "\\json_javatojson.json");
			System.out.println(System.getProperty("user.dir") + "\\json_javatojson.json");
			mapper.writeValue(jsonFile, json_jackson);

			System.out.println(mapper.writeValueAsString(json_jackson));

			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost("PAST YOUR URL HERE");
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", "USERNAME HERE"));
			nvps.add(new BasicNameValuePair("password", "PASSWORD HERE"));
			UrlEncodedFormEntity urlencode = new UrlEncodedFormEntity(nvps);
			httpPost.setEntity(urlencode);
			System.out.println(urlencode);
			CloseableHttpResponse response2 = httpclient.execute(httpPost);

			try {
				System.out.println(response2.getStatusLine());
				HttpEntity entity2 = response2.getEntity();
				// do something useful with the response body
				// and ensure it is fully consumed
				EntityUtils.consume(entity2);
			} finally {
				response2.close();
			}

		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
