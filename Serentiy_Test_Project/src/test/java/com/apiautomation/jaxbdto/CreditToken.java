package com.apiautomation.jaxbdto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class CreditToken {
	
	private List<HeaderDto> header;
	private List<CreditTokenInformationDto> creditTokenInformation;

	public CreditToken(List<HeaderDto> header, List<CreditTokenInformationDto> creditTokenInformation) {
		super();
		this.header = header;
		this.creditTokenInformation = creditTokenInformation;
	}

	@XmlElement
	public List<HeaderDto> getHeader() {
		return header;
	}

	public void setHeader(List<HeaderDto> header) {
		this.header = header;
	}

	@XmlElement
	public List<CreditTokenInformationDto> getCreditTokenInformation() {
		return creditTokenInformation;
	}

	public void setCreditTokenInformation(List<CreditTokenInformationDto> creditTokenInformation) {
		this.creditTokenInformation = creditTokenInformation;
	}


}
