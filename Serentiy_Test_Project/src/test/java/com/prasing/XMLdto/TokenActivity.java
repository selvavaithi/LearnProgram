package com.prasing.XMLdto;

import javax.xml.bind.annotation.XmlElement;

public class TokenActivity {

	String code;

	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
