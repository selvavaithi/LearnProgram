package com.prasing.XMLdto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "user", "tokenTransaction" })
public class CreditTokenInformation {

	List<User> user;
	List<TokenTransaction> tokenTransaction;

	public CreditTokenInformation() {
		user = new ArrayList<User>();
		tokenTransaction = new ArrayList<TokenTransaction>();
	}

	@XmlElement
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@XmlElement
	public List<TokenTransaction> getTokenTransaction() {
		return tokenTransaction;
	}

	public void setTokenTransaction(List<TokenTransaction> tokenTransaction) {
		this.tokenTransaction = tokenTransaction;
	}

}
