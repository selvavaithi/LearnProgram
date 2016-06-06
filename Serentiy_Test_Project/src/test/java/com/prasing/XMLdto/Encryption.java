package com.prasing.XMLdto;

import javax.xml.bind.annotation.XmlElement;

public class Encryption {

	String type;
	String key;

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
