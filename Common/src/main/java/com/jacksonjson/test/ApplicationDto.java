package com.jacksonjson.test;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "AppCode", "PlatformCode"})
public class ApplicationDto {

	String AppCode;
	String PlatformCode;

	public String getAppCode() {
		return AppCode;
	}

	public void setAppCode(String appCode) {
		AppCode = appCode;
	}

	public String getPlatformCode() {
		return PlatformCode;
	}

	public void setPlatformCode(String platformCode) {
		PlatformCode = platformCode;
	}

}
