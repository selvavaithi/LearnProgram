package com.jaxb.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={"user","tokenTransaction"})
public class CreditTokenInformation {

	private List<User> User;
	private List<TokenTransaction> TokenTransaction;

	public CreditTokenInformation() {
		User = new ArrayList<User>();
		TokenTransaction = new ArrayList<TokenTransaction>();
	}

	@XmlElement
	public List<User> getUser() {
		return User;
	}

	public void setUser(List<User> user) {
		User = user;
	}

	@XmlElement
	public List<TokenTransaction> getTokenTransaction() {
		return TokenTransaction;
	}

	public void setTokenTransaction(List<TokenTransaction> tokenTransaction) {
		TokenTransaction = tokenTransaction;
	}
}
