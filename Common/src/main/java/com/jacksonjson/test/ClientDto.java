package com.jacksonjson.test;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "UserAgentId", "DeviceType" })
public class ClientDto {
	String UserAgentId;
	String DeviceType;

	public String getUserAgentId() {
		return UserAgentId;
	}

	public void setUserAgentId(String userAgentId) {
		UserAgentId = userAgentId;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}
}
