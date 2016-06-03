package com.apiautomation.jaxbdto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "creditToken")
public class CreditTokenAPITest {

	private CreditToken creditToken;

	public CreditTokenAPITest(CreditToken creditToken) {
		super();
		this.creditToken = creditToken;
	}

	@XmlElement
	public CreditToken getCreditToken() {
		return creditToken;
	}

	public void setCreditToken(CreditToken creditToken) {
		this.creditToken = creditToken;
	}

	@Override
	public String toString() {
		return "ClassPojo [creditToken = " + creditToken + "]";
	}

}
