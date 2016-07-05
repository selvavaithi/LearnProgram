package com.jaxb.test;

import javax.xml.bind.annotation.XmlElement;

public class TokenActivity {
	private String Code;

	@XmlElement
	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}
}
