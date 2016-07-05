package com.jaxb.test;

import javax.xml.bind.annotation.XmlElement;

public class User {
	private String Email;
	private String GlobalMemberToken;

	@XmlElement
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@XmlElement
	public String getGlobalMemberToken() {
		return GlobalMemberToken;
	}

	public void setGlobalMemberToken(String globalMemberToken) {
		GlobalMemberToken = globalMemberToken;
	}

}
