package com.prasing.jacksonJSON;

import java.io.File;
import java.io.IOException;

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

			mapper.writeValue(jsonFile, json_jackson);

			System.out.println(mapper.writeValueAsString(json_jackson));

		} catch (JsonGenerationException ex) {

			ex.printStackTrace();

		} catch (JsonMappingException ex) {

			ex.printStackTrace();

		} catch (IOException ex) {

			ex.printStackTrace();

		}

	}

}
