package com.jaxb.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class TokenTransaction {

	private TokenActivity TokenActivity;
	private String SourceDevice;
	private int Amount;
	private String Text1;
	private String Text2;

	@XmlElement
	public TokenActivity getTokenActivity() {
		return TokenActivity;
	}

	public void setTokenActivity(TokenActivity tokenActivity) {
		TokenActivity = tokenActivity;
	}

	@XmlElement
	public String getSourceDevice() {
		return SourceDevice;
	}

	public void setSourceDevice(String sourceDevice) {
		SourceDevice = sourceDevice;
	}

	@XmlElement
	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	@XmlElement
	public String getText1() {
		return Text1;
	}

	public void setText1(String text1) {
		Text1 = text1;
	}

	@XmlElement
	public String getText2() {
		return Text2;
	}

	public void setText2(String text2) {
		Text2 = text2;
	}

}
