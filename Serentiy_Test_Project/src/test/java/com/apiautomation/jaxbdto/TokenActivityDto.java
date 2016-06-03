package com.apiautomation.jaxbdto;

import javax.xml.bind.annotation.XmlElement;

public class TokenActivityDto {

	String code;

	public TokenActivityDto(String code) {
		super();
		this.code = code;
	}

	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
