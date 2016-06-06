package com.prasing.XMLdto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "tokenActivity", "sourceDevice", "amount", "text1", "text2" })
public class TokenTransaction {

	List<TokenActivity> tokenActivity;

	String sourceDevice;
	int amount;
	String text1;
	String text2;

	public TokenTransaction() {
		tokenActivity = new ArrayList<TokenActivity>();
	}

	@XmlElement
	public List<TokenActivity> getTokenActivity() {
		return tokenActivity;
	}

	public void setTokenActivity(List<TokenActivity> tokenActivity) {
		this.tokenActivity = tokenActivity;
	}

	@XmlElement
	public String getSourceDevice() {
		return sourceDevice;
	}

	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}

	@XmlElement
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@XmlElement
	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	@XmlElement
	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

}
