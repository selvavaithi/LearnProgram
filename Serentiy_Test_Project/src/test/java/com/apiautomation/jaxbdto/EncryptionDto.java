package com.apiautomation.jaxbdto;

import javax.xml.bind.annotation.XmlElement;

public class EncryptionDto {

	String type;
	String key;

	public EncryptionDto(String type, String key) {
		super();
		this.type = type;
		this.key = key;
	}

	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
