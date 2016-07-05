package com.jaxb.test;

import javax.xml.bind.annotation.XmlElement;

public class Encryption {
	private String Key;
	private String Type;

	@XmlElement
	public String getKey() {
		return Key;
	}

	public void setKey(String Key) {
		this.Key = Key;
	}

	@XmlElement
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}
