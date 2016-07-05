package com.jaxb.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "version", "userAgent", "userAgentId", "businessUnitId", "deviceId", "encryption" })
public class Header {
	private String Version;
	private String UserAgent;
	private int UserAgentId;
	private int BusinessUnitId;
	private int DeviceId;
	private List<Encryption> Encryption;

	public Header() {
		Encryption = new ArrayList<Encryption>();
	}

	@XmlElement
	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	@XmlElement
	public String getUserAgent() {
		return UserAgent;
	}

	public void setUserAgent(String userAgent) {
		UserAgent = userAgent;
	}

	@XmlElement
	public int getUserAgentId() {
		return UserAgentId;
	}

	public void setUserAgentId(int userAgentId) {
		UserAgentId = userAgentId;
	}

	@XmlElement
	public int getBusinessUnitId() {
		return BusinessUnitId;
	}

	public void setBusinessUnitId(int businessUnitId) {
		BusinessUnitId = businessUnitId;
	}

	@XmlElement
	public int getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(int deviceId) {
		DeviceId = deviceId;
	}

	@XmlElement
	public List<Encryption> getEncryption() {
		return Encryption;
	}

	public void setEncryption(List<Encryption> encryption) {
		Encryption = encryption;
	}

}
