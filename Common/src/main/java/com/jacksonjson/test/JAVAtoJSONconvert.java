package com.jacksonjson.test;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JAVAtoJSONconvert {

	public static void main(String[] args) {

		JAVAconvertJSON java2json = new JAVAconvertJSON();

		ApplicationDto Application = new ApplicationDto();
		Application.setAppCode("PCHCOM");
		Application.setPlatformCode("PCHCOMHOME");

		SourceDto Source = new SourceDto();
		Source.setTrackingToken("");
		Source.setSourceCode("PCHCOM");
		Source.setForeignSource("");
		Source.setOriginatingUrl("http://centralservices.cqa.pch.com/rfapi_v9/Svc/TestPage.aspx");
		Source.setMediaChannel("ACQ");
		Source.setEmailSubCode("");

		IpAddressDto IpAddress = new IpAddressDto();
		IpAddress.setServerIp("10.1.1.228");
		IpAddress.setClientIp("24.193.86.57");

		ClientDto Client = new ClientDto();
		Client.setUserAgentId("975138");
		Client.setDeviceType("DESKTOP");

		java2json.setApplication(Application);
		java2json.setSource(Source);
		java2json.setIpAddress(IpAddress);
		java2json.setClient(Client);
		java2json.setGlobalMemberToken("bca8e25b-89c0-4072-97aa-5a7901ddb4d1");
		java2json.setPassword("pch123");

		ObjectMapper objm = new ObjectMapper();

		try {
			String sw = objm.writeValueAsString(java2json);
			System.out.println(sw);
		} catch (JsonGenerationException e) {
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
}
