package com.prasing.XMLdto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
//If you want you can define the order in which the fields are written 
//Optional 
@XmlType(propOrder = { "header", "creditTokenInformation"}) 
public class CreditToken {

	List<Header> header;
	List<CreditTokenInformation> creditTokenInformation;

	public CreditToken() {
		this.header = new ArrayList<Header>();
		this.creditTokenInformation = new ArrayList<CreditTokenInformation>();
	}

	@XmlElement
	public List<Header> getHeader() {
		return header;
	}

	public void setHeader(List<Header> header) {
		this.header = header;
	}

	@XmlElement
	public List<CreditTokenInformation> getCreditTokenInformation() {
		return creditTokenInformation;
	}

	public void setCreditTokenInformation(List<CreditTokenInformation> creditTokenInformation) {
		this.creditTokenInformation = creditTokenInformation;
	}

}
