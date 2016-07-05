package com.jacksonjson.test;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "ServerIp", "ClientIp" })
public class IpAddressDto {
	String ServerIp;
	String ClientIp;

	public String getServerIp() {
		return ServerIp;
	}

	public void setServerIp(String serverIp) {
		ServerIp = serverIp;
	}

	public String getClientIp() {
		return ClientIp;
	}

	public void setClientIp(String clientIp) {
		ClientIp = clientIp;
	}
}
