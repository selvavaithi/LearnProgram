package com.jacksonjson.test;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Application", "Source", "IpAddress", "Client", "GlobalMemberToken", "Password" })
public class JAVAconvertJSON {

	ApplicationDto Application;
	SourceDto Source;
	IpAddressDto IpAddress;
	ClientDto Client;
	String GlobalMemberToken;
	String Password;

	public ApplicationDto getApplication() {
		return Application;
	}

	public void setApplication(ApplicationDto application) {
		Application = application;
	}

	public SourceDto getSource() {
		return Source;
	}

	public void setSource(SourceDto source) {
		Source = source;
	}

	public IpAddressDto getIpAddress() {
		return IpAddress;
	}

	public void setIpAddress(IpAddressDto ipAddress) {
		IpAddress = ipAddress;
	}

	public ClientDto getClient() {
		return Client;
	}

	public void setClient(ClientDto client) {
		Client = client;
	}

	public String getGlobalMemberToken() {
		return GlobalMemberToken;
	}

	public void setGlobalMemberToken(String globalMemberToken) {
		GlobalMemberToken = globalMemberToken;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
