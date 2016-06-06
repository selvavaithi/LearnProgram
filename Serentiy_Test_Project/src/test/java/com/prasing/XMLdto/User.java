package com.prasing.XMLdto;

import javax.xml.bind.annotation.XmlElement;

public class User {

	String email;
	String globalMemberToken;

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getGlobalMemberToken() {
		return globalMemberToken;
	}

	public void setGlobalMemberToken(String globalMemberToken) {
		this.globalMemberToken = globalMemberToken;
	}

}
