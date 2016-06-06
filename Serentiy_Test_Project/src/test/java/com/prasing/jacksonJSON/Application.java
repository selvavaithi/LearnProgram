package com.prasing.jacksonJSON;

public class Application {
	private String PlatformCode;

	private String AppCode;

	public String getPlatformCode() {
		return PlatformCode;
	}

	public void setPlatformCode(String PlatformCode) {
		this.PlatformCode = PlatformCode;
	}

	public String getAppCode() {
		return AppCode;
	}

	public void setAppCode(String AppCode) {
		this.AppCode = AppCode;
	}

	@Override
	public String toString() {
		return "ClassPojo [PlatformCode = " + PlatformCode + ", AppCode = " + AppCode + "]";
	}
}
