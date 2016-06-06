package com.prasing.XMLdto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Header {

	double version;
	String userAgent;
	int userAgentId;
	int businessUnitId;
	int deviceId;
	List<Encryption> encryption;

	public Header() {

		encryption = new ArrayList<Encryption>();
	}

	@XmlElement
	public List<Encryption> getEncryption() {
		return encryption;
	}

	public void setEncryption(List<Encryption> encryption) {
		this.encryption = encryption;
	}

	@XmlElement
	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	@XmlElement
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@XmlElement
	public int getUserAgentId() {
		return userAgentId;
	}

	public void setUserAgentId(int userAgentId) {
		this.userAgentId = userAgentId;
	}

	@XmlElement
	public int getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(int businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	@XmlElement
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

}
