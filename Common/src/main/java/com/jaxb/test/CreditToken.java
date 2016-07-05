package com.jaxb.test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "header", "creditTokenInformation" })
public class CreditToken {

	List<Header> Header;
	List<CreditTokenInformation> CreditTokenInformation;

	public CreditToken() {
		Header = new ArrayList<Header>();
		CreditTokenInformation = new ArrayList<CreditTokenInformation>();
	}

	@XmlElement
	public List<Header> getHeader() {
		return Header;
	}

	public void setHeader(List<Header> header) {
		Header = header;
	}

	@XmlElement
	public List<CreditTokenInformation> getCreditTokenInformation() {
		return CreditTokenInformation;
	}

	public void setCreditTokenInformation(List<CreditTokenInformation> creditTokenInformation) {
		CreditTokenInformation = creditTokenInformation;
	}
}
