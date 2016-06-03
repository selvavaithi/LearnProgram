package com.apiautomation.jaxbdto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CreditTokenInformationDto {

	List<UserDto> user;
	List<TokenTransactionDto> tokenTransaction;

	public CreditTokenInformationDto(List<UserDto> user, List<TokenTransactionDto> tokenTransaction) {
		super();
		this.user = user;
		this.tokenTransaction = tokenTransaction;
	}

	@XmlElement
	public List<UserDto> getUser() {
		return user;
	}

	public void setUser(List<UserDto> user) {
		this.user = user;
	}

	@XmlElement
	public List<TokenTransactionDto> getTokenTransaction() {
		return tokenTransaction;
	}

	public void setTokenTransaction(List<TokenTransactionDto> tokenTransaction) {
		this.tokenTransaction = tokenTransaction;
	}

}
