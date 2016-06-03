package com.apiautomation.jaxbdto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class TokenTransactionDto {

	List<TokenActivityDto> tokenActivity;
	String sourceDevice;
	int amount;
	String text1;
	String text2;

	public TokenTransactionDto(List<TokenActivityDto> tokenActivity, String sourceDevice, int amount, String text1,
			String text2) {
		super();
		this.tokenActivity = tokenActivity;
		this.sourceDevice = sourceDevice;
		this.amount = amount;
		this.text1 = text1;
		this.text2 = text2;
	}

	@XmlElement
	public List<TokenActivityDto> getTokenActivity() {
		return tokenActivity;
	}

	public void setTokenActivity(List<TokenActivityDto> tokenActivity) {
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
