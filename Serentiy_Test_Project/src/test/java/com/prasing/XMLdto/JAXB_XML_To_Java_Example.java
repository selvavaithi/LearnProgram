package com.prasing.XMLdto;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXB_XML_To_Java_Example {

	public static void main(String[] args) {
		try {
			File file = new File(System.getProperty("user.dir") + "\\JAXB_XMLtoJavaExample.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CreditToken.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			CreditToken customer;

			customer = (CreditToken) jaxbUnmarshaller.unmarshal(file);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
