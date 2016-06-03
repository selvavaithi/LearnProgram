package com.apiautomation.jaxbdto;

import javax.xml.bind.annotation.XmlElement;

public class UserDto {

	String email;
	String globalMemberToken;

	public UserDto(String email, String globalMemberToken) {
		super();
		this.email = email;
		this.globalMemberToken = globalMemberToken;
	}

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
